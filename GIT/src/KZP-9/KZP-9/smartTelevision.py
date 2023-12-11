from television import Television
class SmartTelevision(Television):
    def __init__(self, brand, model, screen_size, resolution, has_tuner, tuner_type):
        # Call the constructor of the base class Television
        super().__init__(brand, model, screen_size, resolution)
        self._has_tuner = has_tuner
        self._tuner_type = tuner_type

    # Additional methods to get and set tuner-specific parameters
    def has_tuner(self):
        return self._has_tuner

    def get_tuner_type(self):
        return self._tuner_type

    def set_has_tuner(self, has_tuner):
        self._has_tuner = has_tuner

    def set_tuner_type(self, tuner_type):
        self._tuner_type = tuner_type

    # Overridden method to get information about the smart television
    def get_info(self):
        # Call the base class method to get general television information
        super().get_info()
        print("Has Tuner:", "Yes" if self._has_tuner else "No")
        if self._has_tuner:
            print("Tuner Type:", self._tuner_type)


