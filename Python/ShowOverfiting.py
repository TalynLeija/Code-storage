import matplotlib.pyplot as plt

class Show:
    def __init__(self, Model_History):
        self.Model_History=Model_History


        val_loss = self.Model_History.history["val_loss"]
        epochs = range(1, 21)
        plt.plot(epochs, val_loss, "b--",
                label="Validation loss")
        plt.title("Effect of insufficient model capacity on validation loss")
        plt.xlabel("Epochs")
        plt.ylabel("Loss")
        plt.legend()