```markdown
# 📓 Design Notes

- Modular: Every major part (layers, loss, activation, training) is pluggable
- Expandable: Easily add new activation functions, layers, or optimizers
- Low dependency: Uses no external libraries, just Java
- Clear project layout for collaboration

## Ideas for Future
- Add DropoutLayer
- Add AdamOptimizer
- Add 2D ConvolutionLayer
- Add model checkpointing (saving best model)