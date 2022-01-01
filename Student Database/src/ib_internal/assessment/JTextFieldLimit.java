//code from https://www.rgagnon.com/javadetails/java-0198.html
package ib_internal.assessment;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class JTextFieldLimit extends PlainDocument {
  
    private int limit;
  
  JTextFieldLimit(int limit) {
   super();
   this.limit = limit;
   }
   
  JTextFieldLimit(int limit, boolean upper) {
   super();
   this.limit = limit;
   }
 
    @Override
  public void insertString
    (int offset, String  str, AttributeSet attr)
      throws BadLocationException {
   if (str == null) return;

   if ((getLength() + str.length()) <= limit) {
     super.insertString(offset, str, attr);
     }
   }
}
