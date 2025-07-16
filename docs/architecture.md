# 🧠 Architecture Overview

This project is a modular neural network framework built from scratch in Java.

---

## Flow

1. **Data**  
   A dataset (like XOR) is wrapped in `DataPoint` objects (input + target).

2. **Network**  
   The network (either `NeuralNetwork` or `LayeredModel`) holds a list of layers.

3. **Layer**  
   Each layer has `forward()` and `backward()` methods.

4. **Trainer**  
   Runs the loop: forward → loss → backward → update.

---

## Component Summary

| Component      | Description                                     |
|----------------|-------------------------------------------------|
| Matrix         | Core class for math operations                  |
| Layer          | Base class for Dense, Conv, etc.                |
| Activation     | Plug-in functions like ReLU, Sigmoid            |
| LossFunction   | Calculates error (MSE, CrossEntropy)            |
| Trainer        | Manages training steps                          |
| DataLoader     | Batching and shuffling support                  |
| Logger / Timer | Helpful for debugging and benchmarking          |
