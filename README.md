# Neural Network Java Framework 🤖

A modular, extensible neural network framework written in Java.  
Designed for learning and experimentation with core ML concepts such as layers, activations, loss functions, optimizers, and training loops.

A self-produced project on the topic of Machine learning of which is
Open Source and free for recreational use or inspiration.

---

## Features ⚙️

- Flexible layer system including dense and placeholder convolution layers
- Multiple activation functions: Sigmoid, ReLU, Tanh
- Loss functions: Mean Squared Error (MSE), Cross Entropy
- Trainer supports pluggable loss functions and learning rate schedulers
- Utilities for logging, timing, and exporting data for visualization
- Serialization support for saving/loading models
- Simple DataLoader for batching and shuffling datasets

---

## Getting Started 🚀

### Prerequisites

- Java 11 or later
- Maven or your preferred Java build tool (optional)

### Running the Example

1. Clone the repository
2. Compile the source code
3. Run the `Main` class which includes a demo training the XOR problem

Example command line (if using `javac`/`java`):

```bash
javac -d bin src/**/*.java
java -cp bin Main
+
