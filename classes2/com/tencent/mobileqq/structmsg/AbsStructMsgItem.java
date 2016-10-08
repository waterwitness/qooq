package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.view.StructMsgItemContent;
import com.tencent.mobileqq.structmsg.view.StructMsgItemCover;
import com.tencent.mobileqq.structmsg.view.StructMsgItemHr;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.structmsg.view.StructMsgItemLayout14;
import com.tencent.mobileqq.structmsg.view.StructMsgItemPrice;
import com.tencent.mobileqq.structmsg.view.StructMsgItemSummary;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.xmlpull.v1.XmlSerializer;

public abstract class AbsStructMsgItem
  extends AbsStructMsgElement
{
  public static final int i = 0;
  public static final int j = 2;
  private static final String o = AbsStructMsgItem.class.getSimpleName();
  public ArrayList a;
  public int k;
  protected int l;
  protected int m;
  public int n;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AbsStructMsgItem()
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_n_of_type_Int = b();
  }
  
  public AbsStructMsgItem(int paramInt)
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramInt);
    this.jdField_n_of_type_Int = b();
  }
  
  public AbsStructMsgItem(Collection paramCollection)
  {
    this.jdField_a_of_type_JavaLangString = "item";
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList(paramCollection);
    this.jdField_n_of_type_Int = b();
  }
  
  private boolean b()
  {
    return (this.l >= 0) && (this.l <= 3);
  }
  
  public int a(Context paramContext)
  {
    return (int)(TypedValue.applyDimension(1, 10.0F, paramContext.getResources().getDisplayMetrics()) + 0.5F);
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return b(paramContext, paramView, paramBundle);
  }
  
  public String a()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(b()).append(this.jdField_k_of_type_Int);
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuffer.append(((AbsStructMsgElement)localIterator.next()).a());
      }
    }
    return localStringBuffer.toString();
  }
  
  public void a(View paramView)
  {
    if (!TextUtils.isEmpty(this.b)) {}
    switch (a())
    {
    default: 
      return;
    case 0: 
      paramView.setBackgroundResource(2130837658);
      return;
    case 1: 
      paramView.setBackgroundResource(2130837659);
      return;
    case 2: 
      paramView.setBackgroundResource(2130837657);
      return;
    }
    paramView.setBackgroundResource(2130837656);
  }
  
  public void a(AbsStructMsgElement paramAbsStructMsgElement)
  {
    if (((paramAbsStructMsgElement instanceof AbsStructMsgTextElement)) && (!b())) {
      ((AbsStructMsgTextElement)paramAbsStructMsgElement).o = null;
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramAbsStructMsgElement);
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    this.jdField_e_of_type_Int = paramObjectInput.readInt();
    int i3;
    int i1;
    String str;
    Object localObject;
    if ((this.jdField_e_of_type_Int > 0) && (this.jdField_e_of_type_Int <= 8))
    {
      this.b = paramObjectInput.readUTF();
      this.c = paramObjectInput.readUTF();
      this.d = paramObjectInput.readUTF();
      this.jdField_e_of_type_JavaLangString = paramObjectInput.readUTF();
      this.f = paramObjectInput.readUTF();
      this.jdField_g_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_g_of_type_Int = paramObjectInput.readInt();
      this.jdField_k_of_type_Int = paramObjectInput.readInt();
      if ((2 <= this.jdField_e_of_type_Int) && (this.jdField_e_of_type_Int <= 8)) {
        this.l = paramObjectInput.readInt();
      }
      int i4 = paramObjectInput.readInt();
      i3 = 0;
      i1 = 1;
      if (i3 < i4)
      {
        str = paramObjectInput.readUTF();
        if ("item".equals(str)) {
          localObject = StructMsgElementFactory.a(paramObjectInput.readInt());
        }
      }
    }
    for (;;)
    {
      label180:
      str = b();
      if ((str != null) && (localObject != null) && ((localObject instanceof StructMsgItemCover)))
      {
        if ((!str.endsWith("Layout4")) && (!str.endsWith("Layout2")) && (!str.endsWith("Layout9"))) {
          break label336;
        }
        ((StructMsgItemCover)localObject).jdField_n_of_type_Int = StructMsgItemCover.jdField_k_of_type_Int;
      }
      int i2;
      for (;;)
      {
        if (localObject != null)
        {
          ((AbsStructMsgElement)localObject).jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg;
          ((AbsStructMsgElement)localObject).a(paramObjectInput);
          a((AbsStructMsgElement)localObject);
        }
        i3 += 1;
        break;
        localObject = StructMsgElementFactory.a(str);
        i2 = i1;
        if ("button".equals(str))
        {
          ((AbsStructMsgElement)localObject).m = String.valueOf(i1);
          ((AbsStructMsgElement)localObject).jdField_n_of_type_JavaLangString = this.jdField_n_of_type_JavaLangString;
          i2 = i1 + 1;
        }
        if ((localObject == null) || (!AbsStructMsgItem.class.isInstance(localObject))) {
          break label434;
        }
        paramObjectInput.readInt();
        i1 = i2;
        break label180;
        label336:
        if (str.endsWith("Layout3")) {
          ((StructMsgItemCover)localObject).jdField_n_of_type_Int = StructMsgItemCover.l;
        }
      }
      if ((this.jdField_e_of_type_Int >= 3) && (this.jdField_e_of_type_Int <= 8))
      {
        this.h = paramObjectInput.readUTF();
        if (this.jdField_e_of_type_Int > 5)
        {
          this.i = paramObjectInput.readUTF();
          this.j = paramObjectInput.readUTF();
          this.jdField_k_of_type_JavaLangString = paramObjectInput.readUTF();
        }
      }
      return;
      throw new IOException("structmsg_version_error");
      label434:
      i1 = i2;
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.jdField_a_of_type_JavaLangString);
    paramObjectOutput.writeInt(this.jdField_n_of_type_Int);
    paramObjectOutput.writeInt(this.jdField_e_of_type_Int);
    if (this.b == null)
    {
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.c != null) {
        break label216;
      }
      localObject = "";
      label57:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.d != null) {
        break label224;
      }
      localObject = "";
      label74:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_e_of_type_JavaLangString != null) {
        break label232;
      }
      localObject = "";
      label91:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.f != null) {
        break label240;
      }
      localObject = "";
      label108:
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_g_of_type_JavaLangString != null) {
        break label248;
      }
    }
    label216:
    label224:
    label232:
    label240:
    label248:
    for (Object localObject = "";; localObject = this.jdField_g_of_type_JavaLangString)
    {
      paramObjectOutput.writeUTF((String)localObject);
      paramObjectOutput.writeInt(this.jdField_g_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_k_of_type_Int);
      paramObjectOutput.writeInt(this.l);
      paramObjectOutput.writeInt(this.jdField_a_of_type_JavaUtilArrayList.size());
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramObjectOutput);
      }
      localObject = this.b;
      break;
      localObject = this.c;
      break label57;
      localObject = this.d;
      break label74;
      localObject = this.jdField_e_of_type_JavaLangString;
      break label91;
      localObject = this.f;
      break label108;
    }
    if ((this.jdField_e_of_type_Int >= 3) && (this.jdField_e_of_type_Int <= 8))
    {
      if (this.h != null) {
        break label350;
      }
      localObject = "";
      paramObjectOutput.writeUTF((String)localObject);
      if (this.jdField_e_of_type_Int > 5)
      {
        if (this.i != null) {
          break label358;
        }
        localObject = "";
        label308:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.j != null) {
          break label366;
        }
        localObject = "";
        label325:
        paramObjectOutput.writeUTF((String)localObject);
        if (this.jdField_k_of_type_JavaLangString != null) {
          break label374;
        }
      }
    }
    label350:
    label358:
    label366:
    label374:
    for (localObject = "";; localObject = this.jdField_k_of_type_JavaLangString)
    {
      paramObjectOutput.writeUTF((String)localObject);
      return;
      localObject = this.h;
      break;
      localObject = this.i;
      break label308;
      localObject = this.j;
      break label325;
    }
  }
  
  public void a(String paramString)
  {
    a(new StructMsgItemTitle(paramString));
    a(new StructMsgItemHr());
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, 0, "0");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    a(paramString1, paramString2, paramString3, paramInt, "0");
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    this.jdField_k_of_type_Int = paramInt;
    a(new StructMsgItemCover(paramString1, paramString4));
    a(new StructMsgItemTitle(paramString2));
    a(new StructMsgItemSummary(paramString3));
  }
  
  public void a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
    if ((paramString2 != null) && (!paramString2.equals(""))) {
      a(new StructMsgItemTitle(paramString2));
    }
    if ((paramString1 != null) && (!paramString1.equals(""))) {
      a(new StructMsgItemCover(paramString1));
    }
    if ((paramString3 != null) && (!paramString3.equals(""))) {
      a(new StructMsgItemSummary(paramString3));
    }
    if ((paramString4 != null) && (!paramString4.equals(""))) {
      a(new StructMsgItemPrice(paramString4, paramString5));
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, this.jdField_a_of_type_JavaLangString);
    if (this.jdField_n_of_type_Int < 0) {}
    for (Object localObject = "0";; localObject = String.valueOf(this.jdField_n_of_type_Int))
    {
      paramXmlSerializer.attribute(null, "layout", (String)localObject);
      if (!TextUtils.isEmpty(this.c)) {
        paramXmlSerializer.attribute(null, "action", this.c);
      }
      if (!TextUtils.isEmpty(this.d)) {
        paramXmlSerializer.attribute(null, "actionData", this.d);
      }
      if (!TextUtils.isEmpty(this.jdField_e_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "a_actionData", this.jdField_e_of_type_JavaLangString);
      }
      if (!TextUtils.isEmpty(this.f)) {
        paramXmlSerializer.attribute(null, "i_actionData", this.f);
      }
      if (!TextUtils.isEmpty(this.b)) {
        paramXmlSerializer.attribute(null, "url", this.b);
      }
      if (!TextUtils.isEmpty(this.jdField_g_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "brief", this.jdField_g_of_type_JavaLangString);
      }
      if (this.jdField_g_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "flag", String.valueOf(this.jdField_g_of_type_Int));
      }
      if (this.jdField_k_of_type_Int != 0) {
        paramXmlSerializer.attribute(null, "mode", String.valueOf(this.jdField_k_of_type_Int));
      }
      if (this.l != 0) {
        paramXmlSerializer.attribute(null, "bg", String.valueOf(this.l));
      }
      if (!TextUtils.isEmpty(this.h)) {
        paramXmlSerializer.attribute(null, "businessData", this.h);
      }
      if (!TextUtils.isEmpty(this.i)) {
        paramXmlSerializer.attribute(null, "index", this.i);
      }
      if (!TextUtils.isEmpty(this.j)) {
        paramXmlSerializer.attribute(null, "index_name", this.j);
      }
      if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
        paramXmlSerializer.attribute(null, "index_type", this.jdField_k_of_type_JavaLangString);
      }
      localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((AbsStructMsgElement)((Iterator)localObject).next()).a(paramXmlSerializer);
      }
    }
    paramXmlSerializer.endTag(null, this.jdField_a_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return a() == 1;
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramStructMsgNode == null) {
      bool1 = true;
    }
    for (;;)
    {
      return bool1;
      this.c = paramStructMsgNode.a("action");
      this.d = paramStructMsgNode.a("actionData");
      this.jdField_e_of_type_JavaLangString = paramStructMsgNode.a("a_actionData");
      this.f = paramStructMsgNode.a("i_actionData");
      this.b = paramStructMsgNode.a("url");
      this.jdField_g_of_type_JavaLangString = paramStructMsgNode.a("brief");
      String str = paramStructMsgNode.a("flag");
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        this.jdField_g_of_type_Int = Integer.parseInt(str);
        str = paramStructMsgNode.a("mode");
        if (TextUtils.isEmpty(str)) {}
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        try
        {
          this.jdField_k_of_type_Int = Integer.parseInt(str);
          label125:
          str = paramStructMsgNode.a("bg");
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          try
          {
            if (!TextUtils.isEmpty(str)) {
              if (!str.startsWith("#")) {
                break label258;
              }
            }
            label231:
            label258:
            for (this.l = Color.parseColor(str);; this.l = Integer.parseInt(localNumberFormatException2))
            {
              this.h = paramStructMsgNode.a("businessData");
              this.i = paramStructMsgNode.a("index");
              this.j = paramStructMsgNode.a("index_name");
              this.jdField_k_of_type_JavaLangString = paramStructMsgNode.a("index_type");
              int i3 = paramStructMsgNode.a();
              int i1 = 0;
              for (;;)
              {
                if (i1 >= i3) {
                  break label497;
                }
                localStructMsgNode = paramStructMsgNode.a(i1);
                if (localStructMsgNode != null) {
                  break;
                }
                i1 += 1;
              }
              localNumberFormatException1 = localNumberFormatException1;
              this.jdField_g_of_type_Int = 0;
              break;
              localNumberFormatException2 = localNumberFormatException2;
              this.jdField_k_of_type_Int = 0;
              break label125;
            }
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            StructMsgNode localStructMsgNode;
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.i(o, 2, "Item bg value is " + this.l);
              }
            }
            Object localObject;
            if ("item".equals(localStructMsgNode.b)) {
              localObject = localStructMsgNode.a("layout");
            }
            do
            {
              AbsStructMsgElement localAbsStructMsgElement;
              do
              {
                do
                {
                  do
                  {
                    try
                    {
                      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
                      for (int i2 = Integer.parseInt((String)localObject);; i2 = 0)
                      {
                        localObject = StructMsgElementFactory.a(i2);
                        bool1 = bool2;
                        if (localObject == null) {
                          break;
                        }
                        bool1 = bool2;
                        if (!((AbsStructMsgElement)localObject).a(localStructMsgNode)) {
                          break;
                        }
                        a((AbsStructMsgElement)localObject);
                        break label231;
                      }
                      if (!QLog.isColorLevel()) {
                        break;
                      }
                    }
                    catch (NumberFormatException paramStructMsgNode)
                    {
                      bool1 = bool2;
                    }
                    QLog.i(o, 2, "Item layout value is " + 0);
                    return false;
                    localAbsStructMsgElement = StructMsgElementFactory.a(localStructMsgNode.b);
                    localObject = localAbsStructMsgElement;
                  } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null);
                  localObject = localAbsStructMsgElement;
                } while (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.mMsgServiceID != 70);
                localObject = localAbsStructMsgElement;
              } while (b() != 14);
              localObject = localAbsStructMsgElement;
            } while (StructMsgItemLayout14.a(localStructMsgNode.b));
            a(new StructMsgItemContent("本版本不支持的附件类型"));
            return true;
          }
        }
      }
    }
    label497:
    return true;
  }
  
  protected abstract int b();
  
  public abstract View b(Context paramContext, View paramView, Bundle paramBundle);
  
  public abstract String b();
  
  public void b(View paramView)
  {
    if (!TextUtils.isEmpty(this.b))
    {
      Object localObject = paramView.getLayoutParams();
      int i1 = paramView.getPaddingLeft();
      int i2 = paramView.getPaddingTop();
      int i3 = paramView.getPaddingRight();
      int i4 = paramView.getPaddingBottom();
      switch (a())
      {
      default: 
        paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        paramView.setPadding(i1, i2, i3, i4);
        localObject = paramView.findViewById(2131296359);
        if ((localObject != null) && ((localObject instanceof PAHighLightImageView))) {
          ((PAHighLightImageView)localObject).a();
        }
        break;
      }
    }
    do
    {
      return;
      paramView.setBackgroundResource(2130837658);
      break;
      paramView.setBackgroundResource(2130837659);
      break;
      paramView.setBackgroundResource(2130837657);
      break;
      paramView.setBackgroundResource(2130837656);
      break;
      paramView = paramView.findViewById(2131296504);
    } while ((paramView == null) || (!(paramView instanceof PAHighLightImageView)));
    ((PAHighLightImageView)paramView).a();
  }
  
  public void b(String paramString)
  {
    a(new StructMsgItemSummary(paramString));
    a(new StructMsgItemHr());
  }
  
  public void c(View paramView)
  {
    ViewGroup.LayoutParams localLayoutParams;
    int i1;
    int i2;
    int i3;
    int i4;
    if (!TextUtils.isEmpty(this.b))
    {
      localLayoutParams = paramView.getLayoutParams();
      i1 = paramView.getPaddingLeft();
      i2 = paramView.getPaddingTop();
      i3 = paramView.getPaddingRight();
      i4 = paramView.getPaddingBottom();
      switch (a())
      {
      }
    }
    for (;;)
    {
      paramView.setLayoutParams(localLayoutParams);
      paramView.setPadding(i1, i2, i3, i4);
      return;
      paramView.setBackgroundResource(2130837666);
      continue;
      paramView.setBackgroundResource(2130837669);
      continue;
      paramView.setBackgroundResource(2130837665);
      continue;
      paramView.setBackgroundResource(2130837668);
    }
  }
  
  public void c(String paramString)
  {
    a(new StructMsgItemSummary(paramString));
    a(new StructMsgItemHr());
  }
  
  public void d(int paramInt)
  {
    this.jdField_k_of_type_Int = paramInt;
  }
  
  protected void d(View paramView)
  {
    if ((b()) && (a())) {
      switch (this.l)
      {
      default: 
        if ((paramView != null) && (a() == 1))
        {
          if (this.m == 0) {
            break label128;
          }
          paramView.setBackgroundResource(this.m);
        }
        break;
      }
    }
    label128:
    StateListDrawable localStateListDrawable;
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(this.b))
        {
          this.m = 2130837660;
          break;
        }
        this.m = 2130837670;
        break;
        if (!TextUtils.isEmpty(this.b))
        {
          this.m = 2130837661;
          break;
        }
        this.m = 2130837671;
        break;
        paramView.setBackgroundResource(2130837659);
        return;
      } while ((!a()) || (this.l == 0));
      int i1 = AIOUtils.a(4.0F, paramView.getResources());
      float f1 = i1;
      float f2 = i1;
      float f3 = i1;
      float f4 = i1;
      localStateListDrawable = StructMsgUtils.a(paramView.getResources(), this.l, new float[] { f1, f2, f3, f4, 0.0F, 0.0F, 0.0F, 0.0F });
    } while (localStateListDrawable == null);
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(localStateListDrawable);
      return;
    }
    paramView.setBackground(localStateListDrawable);
  }
  
  public void d(String paramString)
  {
    this.jdField_n_of_type_Int = 0;
    a(new StructMsgItemImage(paramString));
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\AbsStructMsgItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */