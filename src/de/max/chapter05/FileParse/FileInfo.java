package de.max.chapter05.FileParse;

public class FileInfo {

	private boolean isRelative;
	private String driveLetter = null;
	private String path;
	private String fileName;
	private String extension;

	public FileInfo(String dir)
	{
		parse(dir);
	}

	public void printInfo()
	{
		System.out.format("relative %s\n", isRelative);
		System.out.format("Drive Letter: %s\n", driveLetter);
		System.out.format("Dir: %s\n", path);
		System.out.format("fileName: %s\n", fileName);
		System.out.format("extension: %s\n", extension);
	}

	public void parse(String dir)
	{

		String[] splitArgs = dir.split("[/\\\\]");
		int argLen = splitArgs.length;
		// is path start with any variant of ..
		if (splitArgs[0].equals(".."))
		{
			isRelative = true;
		}
		// last element will always be the file split that again if is has an
		// extension
		String[] extension = splitArgs[argLen - 1].split("[.]");
		if (extension.length > 1)
		{
			this.fileName = extension[0];
			this.extension = extension[1];
		} else
		{
			this.fileName = splitArgs[argLen - 1];
		}
		// if : system is Windows so the seperator will be a \
		if (splitArgs[0].length() > 1 && splitArgs[0].charAt(1) == ':')
		{
			driveLetter = splitArgs[0].substring(0, 1);
		}
		if (dir.indexOf('/') == -1)
			// is unix
			path = dir.substring(dir.indexOf("\\"), dir.lastIndexOf("\\"));
		else
			// is windows
			path = dir.substring(dir.indexOf("/"), dir.lastIndexOf("/"));
		// remove any leading trash
		if (isRelative)
		{
			while (path.indexOf("..") != -1)
			{
				path = path.replaceFirst("[/\\\\]..", "");

			}
		}
	}

}
