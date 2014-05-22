public class IconOption {
	public String IconPath = null;
	public String IconValue = null;

	public IconOption(String IconPath, String IconValue) {
		this.IconPath = IconPath;
		this.IconValue = IconValue;
	}

	public String getIconPath() {
		return IconPath;
	}

	public String getIconValue() {
		return IconValue;
	}

	public String toString() {

		return "IconPath: " + this.getIconPath() + "\t" + "IconValue: "
				+ this.getIconValue();
	}
}
