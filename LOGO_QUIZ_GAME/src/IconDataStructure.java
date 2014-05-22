import java.io.*;
import java.util.*;

public class IconDataStructure {
	public static ArrayList<IconOption> IconCollection = null;
	public static int IconDataStructureSize = 0;

	public static void initializeIconDataStructure() {
		IconCollection = new ArrayList<IconOption>();
		IconDataStructureSize = 0;
	}

	public static void LoadDataBase(String FolderPath) {
		File folder = new File(FolderPath);
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
			if (listOfFiles[i].isFile()) {
				if (!listOfFiles[i].getName().equalsIgnoreCase("Values.txt")) {
					IconCollection.add(new IconOption(listOfFiles[i]
							.getAbsolutePath(), getValueByName(
							listOfFiles[i].getName(), FolderPath)));
					IconDataStructureSize++;
				}
			}
		}
	}

	public static String getValueByName(String name, String folderPath) {
		String temp = null;
		folderPath += "\\Values.txt";
		try {
			@SuppressWarnings("resource")
			BufferedReader reader = new BufferedReader(new FileReader(
					folderPath));
			while ((temp = reader.readLine()) != null)
				if (temp.contains("{" + name + "}" + "="))
					return temp.substring(temp.indexOf("=") + 1, temp.length());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String toStringOverrided() {
		String s = "IconCollection Size: " + IconDataStructureSize + "\n";
		Iterator<IconOption> it = IconCollection.iterator();

		while (it.hasNext())
			s += it.next().toString() + "\n";
		return s;
	}

	public static IconOption[] getPackOfOptions(int packSize) {
		if (packSize > getIconDataStructureSize())
			return null;
		IconOption[] array = new IconOption[packSize];
		IconOption ref = null;
		int numberOfFound = 0;
		while (true) {
			ref = IconCollection
					.get(randInt(0, getIconDataStructureSize() - 1));
			if (!Arrays.asList(array).contains(ref)) {
				array[numberOfFound] = ref;
				numberOfFound++;

				if (numberOfFound == array.length) {
					return array;
				}
			}
		}
	}

	public static int randInt(int min, int max) {
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	public static int getIconDataStructureSize() {
		return IconDataStructureSize;
	}

}
