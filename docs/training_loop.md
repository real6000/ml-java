

```markdown
# 🔁 Training Loop

This is how model training works internally:

---

## Flow

1. Shuffle the dataset
2. For each epoch:
   - For each batch:
     - Forward pass through all layers
     - Compute loss
     - Backward pass to compute gradients
     - Update weights
   - Optionally log loss and accuracy

---

## In Code

```java
for (int epoch = 1; epoch <= totalEpochs; epoch++) {
    for (DataPoint dp : data) {
        Matrix output = model.forward(dp.getInput());
        double loss = lossFunction.calculate(dp.getTarget(), output);
        Matrix grad = lossFunction.gradient(dp.getTarget(), output);
        model.backward(grad, learningRate);
    }
}
