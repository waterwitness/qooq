package com.tencent.bitapp;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class BitAppMsgParserHandler
  extends DefaultHandler
{
  BitAppMsgNode jdField_a_of_type_ComTencentBitappBitAppMsgNode;
  Stack jdField_a_of_type_JavaUtilStack;
  private boolean jdField_a_of_type_Boolean;
  
  public BitAppMsgParserHandler()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaUtilStack = new Stack();
  }
  
  public BitAppMsgNode a()
  {
    return this.jdField_a_of_type_ComTencentBitappBitAppMsgNode;
  }
  
  public void characters(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    super.characters(paramArrayOfChar, paramInt1, paramInt2);
    paramArrayOfChar = new String(paramArrayOfChar, paramInt1, paramInt2);
    BitAppMsgNode localBitAppMsgNode;
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      localBitAppMsgNode = (BitAppMsgNode)this.jdField_a_of_type_JavaUtilStack.peek();
      if (localBitAppMsgNode != null) {
        if (localBitAppMsgNode.jdField_a_of_type_JavaLangString != null) {
          break label60;
        }
      }
    }
    for (;;)
    {
      localBitAppMsgNode.jdField_a_of_type_JavaLangString = paramArrayOfChar;
      return;
      label60:
      paramArrayOfChar = localBitAppMsgNode.jdField_a_of_type_JavaLangString.concat(paramArrayOfChar);
    }
  }
  
  public void endDocument()
  {
    super.endDocument();
    this.jdField_a_of_type_JavaUtilStack.clear();
    this.jdField_a_of_type_JavaUtilStack = null;
  }
  
  public void endElement(String paramString1, String paramString2, String paramString3)
  {
    super.endElement(paramString1, paramString2, paramString3);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString1 = (BitAppMsgNode)this.jdField_a_of_type_JavaUtilStack.pop();
      if (this.jdField_a_of_type_JavaUtilStack.isEmpty()) {
        this.jdField_a_of_type_ComTencentBitappBitAppMsgNode = paramString1;
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if ((paramString1 != null) && (!"".equals(paramString1.jdField_a_of_type_JavaLangString))) {
          paramString1.jdField_a_of_type_Int = 3;
        }
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public void startElement(String paramString1, String paramString2, String paramString3, Attributes paramAttributes)
  {
    super.startElement(paramString1, paramString2, paramString3, paramAttributes);
    int j = paramAttributes.getLength();
    paramString1 = new HashMap(j);
    int i = 0;
    while (i < j)
    {
      paramString1.put(paramAttributes.getLocalName(i), paramAttributes.getValue(i));
      i += 1;
    }
    paramString1 = new BitAppMsgNode(paramString2, paramString1);
    if (!this.jdField_a_of_type_JavaUtilStack.isEmpty())
    {
      paramString2 = (BitAppMsgNode)this.jdField_a_of_type_JavaUtilStack.peek();
      if (paramString2 != null)
      {
        paramString1.jdField_a_of_type_ComTencentBitappBitAppMsgNode = paramString2;
        paramString2.a(paramString1);
      }
    }
    this.jdField_a_of_type_JavaUtilStack.push(paramString1);
    this.jdField_a_of_type_Boolean = true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\bitapp\BitAppMsgParserHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */