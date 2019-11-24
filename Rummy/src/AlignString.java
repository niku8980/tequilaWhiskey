import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class AlignString 
{
	private String alignment;
	private int stringLength;
	
	public AlignString(int stringLength, String alignment)
	{
		switch(alignment)
		{
		case "LEFT":
		case "CENTER":
		case "RIGHT":
			this.alignment = alignment;
			this.stringLength = stringLength;
			break;
		}
	}
	
	//public StringBuffer format(Object input, StringBuffer where, FieldPosition ignore)
	//{
	//	String str = input.toString();
		//
	//}
}
