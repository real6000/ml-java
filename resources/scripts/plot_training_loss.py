""" 
plot_training_loss.py

This script visualizes the training loss of the neural network.
It expects a file 'training_loss.csv' with two columns: epoch, loss.

"""

import matplotlib.pyplot as plt
import csv
import os

def load_loss_data(file_path):
    epochs, losses = [], []
    with open(file_path, mode ='r') as file:
        reader = csv.reader(file)
        next(reader)  # Skip header
        for row in reader:
            epochs.append(int(row[0]))
            losses.append(float(row[1]))
    return epochs, losses

def plot_loss(epochs, losses):
    plt.figure(figsize=(10, 6))
    plt.plot(epochs, losses, label="Training Loss", color='teal', linewidth=2)
    plt.xlabel("Epoch")
    plt.ylabel("Loss")
    plt.title("Neural Network Training Loss Over Time")
    plt.grid(True)
    plt.legend()
    plt.tight_layout()
    plt.show()

if __name__ == "__main__":
    loss_file = os.path.join(os.path.dirname(__file__), "../../logs/training_loss.csv")
    if os.path.exists(loss_file):
        epochs, losses = load_loss_data(loss_file)
        plot_loss(epochs, losses)
    else:
        print(f"Training loss file not found at: {loss_file}")