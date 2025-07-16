# architecture.md

This document explains the overall flow of the neural network framework.

- DataPoint holds input and expected output.
- NeuralNetwork or LayeredModel holds layers.
- Each Layer implements forward() and backward().
- Trainer handles the training loop and updates weights.