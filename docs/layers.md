# 🧱 Layers System

This framework supports easily adding and composing different layer types.

---

## Supported Layers

- **DenseLayer** – Fully connected layer with weights and biases
- **ConvolutionLayer** – Placeholder for 1D/2D CNNs (expandable)
- **DropoutLayer** *(planned)* – For regularization
- **BatchNormLayer** *(planned)* – For stabilized training

---

## Layer Contract

Each layer implements:

```java
Matrix forward(Matrix input);
Matrix backward(Matrix grad, double learningRate);
