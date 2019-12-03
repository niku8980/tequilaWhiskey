package rummy;

/**
 * This is a class to align strings in center, left and right
 * @author Brandon Staton, Dillon Kilroy, Nick Patel
 * @version 1.0
 */


public class AlignString 
{
		 
	/**
	 * What alignment is to be used to align the string 
	 */
	private String alignment;
	
	/**
	 * The length of the entire line
	 */
	private int stringLength;
	
	/**
	 * This creates an object of a specific Alignment
	 * @param stringLength The length of the entire line
	 * @param alignment The alignment by which the string is to be aligned.
	 */
	public AlignString(int stringLength, String alignment)
	{
		switch(alignment)
		{
		case "LEFTPLAYER":
		case "CENTERPLAYER":
		case "RIGHTPLAYER":
		case "LEFTCARD":
		case "RIGHTCARD":
		case "CENTERCARD":
			this.alignment = alignment;
			this.stringLength = stringLength;
			break;
		}
	} 
	
	/**
	 * This function formats the string according to the alignment
	 * @param input The string which is to be aligned
	 * @return The aligned string
	 */
	
	public String format(String input)
	{
		String str = input;
		StringBuilder retString = new StringBuilder();
		switch(alignment)
		{
			case "CENTERPLAYER" :
				pad(retString, (stringLength)/2 - 24);
				retString.append(str);
				pad(retString, (stringLength)/2 - input.length());
				break;
			case "CENTERCARD":
				pad(retString, (stringLength)/2- 24);
				retString.append(str + " ");
				break;
			case "LEFTPLAYER" :
				retString.append(str);
				pad(retString, stringLength - str.length());
				break;
			case "LEFTCARD":
				retString.append(str + " ");
				break;
			case "RIGHTPLAYER": 
				pad(retString, stringLength - 50);
				retString.append(str);
				break;				
			case "RIGHTCARD":
				pad(retString, stringLength - 50);
				retString.append(str);
				break;
		}	
		retString.append("\n");  
		return retString.toString();
	}
	
	/**
	 * This function adds paddingLength number of white spaces to the string 
	 * @param str The string which is to be padded
	 * @param paddingLength The number of white spaces to be added to the string
	 */
	
	protected final void pad(StringBuilder str, int paddingLength)
	{
		for(int i = 0; i < paddingLength; i++)
		{
			str.append(' ');
		}
	}
}
