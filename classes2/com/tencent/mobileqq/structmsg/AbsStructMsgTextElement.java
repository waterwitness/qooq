package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.service.message.MessageUtils;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle.TitleTextView;
import com.tencent.mobileqq.utils.StringUtil;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgTextElement
  extends AbsStructMsgElement
  implements View.OnClickListener
{
  protected boolean a;
  protected boolean b;
  protected String o;
  protected String p;
  protected String q;
  protected String r;
  protected String s;
  protected String t;
  protected String u;
  protected String v;
  
  public AbsStructMsgTextElement()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AbsStructMsgTextElement(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.u = paramString1;
  }
  
  protected TextUtils.TruncateAt a()
  {
    return TextUtils.TruncateAt.END;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    if ((paramView != null) && (a().isInstance(paramView)))
    {
      paramView = (TextView)paramView;
      paramView.setTag(this);
      if (!this.b) {
        break label185;
      }
      paramView.setSingleLine(true);
    }
    for (;;)
    {
      if ((this.b) || (!this.jdField_a_of_type_Boolean)) {
        paramView.setEllipsize(a());
      }
      paramContext = a(paramContext.getResources());
      if (paramContext == null) {
        break label213;
      }
      paramView.setTextColor(paramContext.jdField_a_of_type_Int);
      paramView.requestLayout();
      paramView.setTypeface(Typeface.DEFAULT, paramContext.jdField_b_of_type_Int);
      paramView.setTextSize(paramContext.c);
      if (paramContext.jdField_a_of_type_Boolean == true) {
        paramView.getPaint().setFlags(8);
      }
      if ((paramContext.jdField_b_of_type_JavaLangString == null) || (paramContext.jdField_b_of_type_JavaLangString.equals("")) || (!paramContext.jdField_b_of_type_JavaLangString.trim().equals("1"))) {
        break label203;
      }
      paramView.setText(Html.fromHtml(paramContext.jdField_a_of_type_JavaLangString));
      return paramView;
      paramView = a(paramContext);
      paramView.setId(c());
      break;
      label185:
      if (!this.jdField_a_of_type_Boolean) {
        paramView.setMaxLines(b());
      }
    }
    label203:
    paramView.setText(paramContext.jdField_a_of_type_JavaLangString);
    return paramView;
    label213:
    paramView.setText("");
    return paramView;
  }
  
  public TextView a(Context paramContext)
  {
    if (StructMsgItemTitle.TitleTextView.class.isAssignableFrom(a())) {
      return new StructMsgItemTitle.TitleTextView(paramContext);
    }
    return new TextView(paramContext);
  }
  
  /* Error */
  public AbsStructMsgTextElement.RichText a(android.content.res.Resources paramResources)
  {
    // Byte code:
    //   0: new 81	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText
    //   3: dup
    //   4: invokespecial 173	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:<init>	()V
    //   7: astore_1
    //   8: aload_0
    //   9: getfield 175	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:p	Ljava/lang/String;
    //   12: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   15: ifne +151 -> 166
    //   18: aload_1
    //   19: aload_0
    //   20: getfield 175	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:p	Ljava/lang/String;
    //   23: invokestatic 187	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   26: putfield 84	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Int	I
    //   29: aload_0
    //   30: getfield 189	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:q	Ljava/lang/String;
    //   33: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   36: ifeq +176 -> 212
    //   39: aload_0
    //   40: invokevirtual 192	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:f	()I
    //   43: istore_3
    //   44: aload_1
    //   45: iload_3
    //   46: putfield 99	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   49: aload_0
    //   50: getfield 194	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:v	Ljava/lang/String;
    //   53: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   56: ifeq +167 -> 223
    //   59: iconst_0
    //   60: istore_3
    //   61: aload_1
    //   62: iload_3
    //   63: putfield 197	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:d	I
    //   66: aload_1
    //   67: iconst_0
    //   68: putfield 111	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Boolean	Z
    //   71: aload_1
    //   72: getfield 99	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   75: iflt +11 -> 86
    //   78: aload_1
    //   79: getfield 99	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   82: iconst_4
    //   83: if_icmplt +24 -> 107
    //   86: aload_1
    //   87: getfield 99	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   90: iconst_4
    //   91: if_icmpne +8 -> 99
    //   94: aload_1
    //   95: iconst_1
    //   96: putfield 111	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Boolean	Z
    //   99: aload_1
    //   100: aload_0
    //   101: invokevirtual 192	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:f	()I
    //   104: putfield 99	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_Int	I
    //   107: aload_0
    //   108: getfield 199	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:s	Ljava/lang/String;
    //   111: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   114: ifne +129 -> 243
    //   117: aload_1
    //   118: aload_0
    //   119: getfield 199	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:s	Ljava/lang/String;
    //   122: invokestatic 204	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   125: putfield 106	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   128: aload_1
    //   129: getfield 106	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   132: iconst_1
    //   133: if_icmpge +11 -> 144
    //   136: aload_1
    //   137: aload_0
    //   138: invokevirtual 207	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:e	()I
    //   141: putfield 106	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   144: aload_1
    //   145: aload_1
    //   146: getfield 106	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   149: iconst_2
    //   150: idiv
    //   151: putfield 106	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   154: aload_0
    //   155: invokevirtual 209	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:b	()Ljava/lang/String;
    //   158: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   161: ifeq +116 -> 277
    //   164: aconst_null
    //   165: areturn
    //   166: aload_0
    //   167: getfield 211	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:o	Ljava/lang/String;
    //   170: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   173: ifeq +28 -> 201
    //   176: aload_0
    //   177: invokevirtual 213	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:d	()I
    //   180: istore_3
    //   181: aload_1
    //   182: iload_3
    //   183: putfield 84	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Int	I
    //   186: goto -157 -> 29
    //   189: astore_2
    //   190: aload_1
    //   191: aload_0
    //   192: invokevirtual 213	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:d	()I
    //   195: putfield 84	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_Int	I
    //   198: goto -169 -> 29
    //   201: aload_0
    //   202: getfield 211	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:o	Ljava/lang/String;
    //   205: invokestatic 187	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   208: istore_3
    //   209: goto -28 -> 181
    //   212: aload_0
    //   213: getfield 189	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:q	Ljava/lang/String;
    //   216: invokestatic 204	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   219: istore_3
    //   220: goto -176 -> 44
    //   223: aload_0
    //   224: getfield 194	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:v	Ljava/lang/String;
    //   227: invokestatic 204	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   230: istore_3
    //   231: goto -170 -> 61
    //   234: astore_2
    //   235: aload_1
    //   236: iconst_0
    //   237: putfield 197	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:d	I
    //   240: goto -174 -> 66
    //   243: aload_0
    //   244: getfield 215	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:r	Ljava/lang/String;
    //   247: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   250: ifeq +16 -> 266
    //   253: aload_0
    //   254: invokevirtual 207	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:e	()I
    //   257: istore_3
    //   258: aload_1
    //   259: iload_3
    //   260: putfield 106	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:c	I
    //   263: goto -135 -> 128
    //   266: aload_0
    //   267: getfield 215	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:r	Ljava/lang/String;
    //   270: invokestatic 204	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   273: istore_3
    //   274: goto -16 -> 258
    //   277: aload_1
    //   278: aload_0
    //   279: invokevirtual 209	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:b	()Ljava/lang/String;
    //   282: putfield 136	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   285: aload_1
    //   286: aload_0
    //   287: getfield 217	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement:t	Ljava/lang/String;
    //   290: putfield 122	com/tencent/mobileqq/structmsg/AbsStructMsgTextElement$RichText:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   293: aload_1
    //   294: areturn
    //   295: astore_2
    //   296: goto -247 -> 49
    //   299: astore_2
    //   300: goto -172 -> 128
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	303	0	this	AbsStructMsgTextElement
    //   0	303	1	paramResources	android.content.res.Resources
    //   189	1	2	localException1	Exception
    //   234	1	2	localException2	Exception
    //   295	1	2	localException3	Exception
    //   299	1	2	localException4	Exception
    //   43	231	3	i	int
    // Exception table:
    //   from	to	target	type
    //   8	29	189	java/lang/Exception
    //   166	181	189	java/lang/Exception
    //   181	186	189	java/lang/Exception
    //   201	209	189	java/lang/Exception
    //   49	59	234	java/lang/Exception
    //   61	66	234	java/lang/Exception
    //   223	231	234	java/lang/Exception
    //   29	44	295	java/lang/Exception
    //   44	49	295	java/lang/Exception
    //   212	220	295	java/lang/Exception
    //   107	128	299	java/lang/Exception
    //   243	258	299	java/lang/Exception
    //   258	263	299	java/lang/Exception
    //   266	274	299	java/lang/Exception
  }
  
  public Class a()
  {
    return TextView.class;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    if (this.e == 1) {
      this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
    }
    do
    {
      return;
      if (this.e == 2)
      {
        this.o = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.q = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.r = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
        return;
      }
      if (this.e == 3)
      {
        this.o = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.q = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.r = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
        this.t = MessageUtils.a(paramObjectInput.readUTF(), false);
        return;
      }
    } while (this.e < 4);
    this.o = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.q = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.r = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.u = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.t = MessageUtils.a(paramObjectInput.readUTF(), false);
    this.v = MessageUtils.a(paramObjectInput.readUTF(), false);
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.e == 1) {
      if (this.u == null)
      {
        str = "";
        paramObjectOutput.writeUTF(str);
      }
    }
    label78:
    label95:
    label128:
    label136:
    label144:
    label191:
    label208:
    label225:
    label258:
    label266:
    label274:
    label286:
    do
    {
      return;
      str = MessageUtils.a(this.u, false);
      break;
      if (this.e == 2)
      {
        if (this.o == null)
        {
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.q != null) {
            break label128;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.r != null) {
            break label136;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.u != null) {
            break label144;
          }
        }
        for (str = "";; str = MessageUtils.a(this.u, false))
        {
          paramObjectOutput.writeUTF(str);
          return;
          str = this.o;
          break;
          str = this.q;
          break label78;
          str = this.r;
          break label95;
        }
      }
      if (this.e == 3)
      {
        if (this.o == null)
        {
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.q != null) {
            break label258;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.r != null) {
            break label266;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.u != null) {
            break label274;
          }
          str = "";
          paramObjectOutput.writeUTF(str);
          if (this.t != null) {
            break label286;
          }
        }
        for (str = "";; str = this.t)
        {
          paramObjectOutput.writeUTF(str);
          return;
          str = this.o;
          break;
          str = this.q;
          break label191;
          str = this.r;
          break label208;
          str = MessageUtils.a(this.u, false);
          break label225;
        }
      }
    } while (this.e < 4);
    if (this.o == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.q != null) {
        break label413;
      }
      str = "";
      label329:
      paramObjectOutput.writeUTF(str);
      if (this.r != null) {
        break label421;
      }
      str = "";
      label346:
      paramObjectOutput.writeUTF(str);
      if (this.u != null) {
        break label429;
      }
      str = "";
      label363:
      paramObjectOutput.writeUTF(str);
      if (this.t != null) {
        break label441;
      }
      str = "";
      label380:
      paramObjectOutput.writeUTF(str);
      if (this.v != null) {
        break label449;
      }
    }
    label413:
    label421:
    label429:
    label441:
    label449:
    for (String str = "";; str = this.v)
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = this.o;
      break;
      str = this.q;
      break label329;
      str = this.r;
      break label346;
      str = MessageUtils.a(this.u, false);
      break label363;
      str = this.t;
      break label380;
    }
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.equals("")))
    {
      this.u = paramString;
      return;
    }
    this.u = StringUtil.h(paramString);
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.u != null)
    {
      if (!TextUtils.isEmpty(this.r)) {
        paramXmlSerializer.attribute(null, "size", this.r);
      }
      if (!TextUtils.isEmpty(this.o)) {
        paramXmlSerializer.attribute(null, "color", this.o);
      }
      if (!TextUtils.isEmpty(this.q)) {
        paramXmlSerializer.attribute(null, "style", this.q);
      }
      paramXmlSerializer.text(this.u);
      if (!TextUtils.isEmpty(this.t)) {
        paramXmlSerializer.attribute(null, "html", this.t);
      }
      if (!TextUtils.isEmpty(this.v)) {
        paramXmlSerializer.attribute(null, "type", this.v);
      }
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {
      return true;
    }
    this.o = paramStructMsgNode.a("color");
    this.q = paramStructMsgNode.a("style");
    this.r = paramStructMsgNode.a("size");
    this.u = MessageUtils.a(StructMsgFactory.a(paramStructMsgNode), false);
    this.t = paramStructMsgNode.a("html");
    this.v = paramStructMsgNode.a("type");
    return true;
  }
  
  public int b()
  {
    return 2;
  }
  
  public String b()
  {
    if (this.u == null) {}
    for (String str = "";; str = this.u)
    {
      this.u = str;
      return this.u;
    }
  }
  
  public void b(String paramString)
  {
    this.p = paramString;
  }
  
  protected abstract int c();
  
  public String c()
  {
    return this.r;
  }
  
  public void c(String paramString)
  {
    this.q = paramString;
  }
  
  public int d()
  {
    return -16777216;
  }
  
  public String d()
  {
    return this.o;
  }
  
  public void d(String paramString)
  {
    this.s = paramString;
  }
  
  public int e()
  {
    return 26;
  }
  
  public String e()
  {
    return this.q;
  }
  
  public void e(String paramString)
  {
    this.v = paramString;
  }
  
  public int f()
  {
    return 0;
  }
  
  public String f()
  {
    return this.v;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\AbsStructMsgTextElement.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */