from smartTelevision import Television, SmartTelevision
if __name__ == "__main__":
    # Creating an object of the Television class
    my_tv = Television(brand="Sony", model="Bravia", screen_size=55, resolution="4K")

    # Displaying information about the television
    print("=== Television Information ===")
    my_tv.get_info()
    print("=============================")

    # Changing some parameters
    my_tv.set_screen_size(65)
    my_tv.set_resolution("8K")

    # Displaying updated information about the television
    print("\n=== Updated Television Information ===")
    my_tv.get_info()
    print("=============================")

    # Creating an object of the SmartTelevision class
    my_smart_tv = SmartTelevision(brand="Samsung", model="QLED", screen_size=50, resolution="4K",
                                  has_tuner=True, tuner_type="Digital")

    # Displaying information about the smart television
    print("\n=== Smart Television Information ===")
    my_smart_tv.get_info()
    print("=============================")

    # Changing some parameters
    my_smart_tv.set_has_tuner(False)
    my_smart_tv.set_tuner_type("Analog")

    # Displaying updated information about the smart television
    print("\n=== Updated Smart Television Information ===")
    my_smart_tv.get_info()
    print("=============================")

