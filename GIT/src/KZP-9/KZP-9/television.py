class Television:
    def __init__(self, brand, model, screen_size, resolution):
        self._brand = brand
        self._model = model
        self._screen_size = screen_size
        self._resolution = resolution

    # Getter methods
    def get_brand(self):
        return self._brand

    def get_model(self):
        return self._model

    def get_screen_size(self):
        return self._screen_size

    def get_resolution(self):
        return self._resolution

    # Setter methods
    def set_brand(self, brand):
        self._brand = brand

    def set_model(self, model):
        self._model = model

    def set_screen_size(self, screen_size):
        self._screen_size = screen_size

    def set_resolution(self, resolution):
        self._resolution = resolution

    # Method to get information about the television
    def get_info(self):
        print("Brand:", self._brand)
        print("Model:", self._model)
        print("Screen Size:", self._screen_size, "inches")
        print("Resolution:", self._resolution)


