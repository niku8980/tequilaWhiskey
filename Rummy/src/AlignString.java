public class AlignString 
{
	private String alignment;
	private int stringLength;
	
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
		case "CENTERCASE":
			this.alignment = alignment;
			this.stringLength = stringLength;
			break;
		}
	} 
	
	public String format(String input)
	{
		String str = input.toString();
		StringBuilder retString = new StringBuilder();
		switch(alignment)
		{
			case "CENTERPLAYER" :
				pad(retString, (stringLength)/2);
				retString.append(str);
				pad(retString, (stringLength)/2);
				break;
			case "CENTERCARD":
				pad(retString, (stringLength)/2);
				retString.append(str + " ");
				break;
			case "LEFTPLAYER" :
				retString.append(str);
				pad(retString, stringLength - str.length());
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
	
	protected final void pad(StringBuilder str, int paddingLength)
	{
		for(int i = 0; i < paddingLength; i++)
			str.append(' ');
	}
}
