package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.widget.AnyScaleTypeImageView;
import com.tencent.mobileqq.widget.CustomScaleType;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.lang.ref.WeakReference;
import org.xmlpull.v1.XmlSerializer;
import uwq;
import uwr;

public class StructMsgItemPAVideo
  extends AbsStructMsgElement
{
  public static final String o = "structmsg.StructMsgItemVideoForPA";
  public View.OnClickListener a;
  private URLDrawableDownListener.Adapter a;
  public String p;
  private String q;
  private String r;
  
  public StructMsgItemPAVideo()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uwq(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new uwr(this);
    this.jdField_a_of_type_JavaLangString = "pavideo";
  }
  
  public StructMsgItemPAVideo(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new uwq(this);
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new uwr(this);
    this.jdField_a_of_type_JavaLangString = "pavideo";
    this.p = paramString1;
    this.q = paramString2;
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    paramBundle = paramContext.getResources();
    int i = paramBundle.getDisplayMetrics().widthPixels;
    if ((paramView != null) && ((paramView instanceof AnyScaleTypeImageView))) {
      paramView = (PAHighLightImageView)paramView;
    }
    for (;;)
    {
      paramView.setTag(this);
      try
      {
        paramBundle = paramBundle.getDrawable(2130838896);
        if (TextUtils.isEmpty(this.p))
        {
          paramView.setBackgroundDrawable(paramBundle);
          if (this.jdField_a_of_type_JavaLangRefWeakReference != null)
          {
            paramView.setOnLongClickListener((View.OnLongClickListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
            paramView.setOnTouchListener((View.OnTouchListener)this.jdField_a_of_type_JavaLangRefWeakReference.get());
          }
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          return paramView;
          paramView = new PAHighLightImageView(paramContext);
          paramView.setId(2131296359);
          paramView.setContentDescription(paramBundle.getString(2131367318));
          paramView.setDisplayRuleDef(CustomScaleType.a);
          paramView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
          paramView.setContentDescription(paramBundle.getText(2131371169));
        }
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          paramBundle = null;
        }
        paramBundle = URLDrawable.getDrawable(this.p, i, i, paramBundle, paramBundle);
        if (AbsDownloader.a(this.p)) {
          break label191;
        }
      }
    }
    label191:
    boolean bool;
    if (!URLDrawableHelper.a(paramContext))
    {
      bool = true;
      label194:
      paramBundle.setAutoDownload(bool);
      if ((paramBundle == null) || (paramBundle.getStatus() != 1)) {
        break label231;
      }
      paramView.setBackgroundDrawable(null);
    }
    for (;;)
    {
      paramView.setBackgroundDrawable(paramBundle);
      break;
      bool = false;
      break label194;
      label231:
      paramView.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      paramView.setBackgroundColor(15790320);
    }
  }
  
  public StructMsgForGeneralShare a(View paramView)
  {
    for (paramView = paramView.getParent(); paramView != null; paramView = paramView.getParent())
    {
      paramView = (ViewGroup)paramView;
      if (paramView.getId() == 2131296312) {
        return (StructMsgForGeneralShare)paramView.getTag(2131296312);
      }
    }
    return null;
  }
  
  public String a()
  {
    return "pavideo";
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.p = paramObjectInput.readUTF();
    this.q = paramObjectInput.readUTF();
    if (this.e > 5)
    {
      this.r = paramObjectInput.readUTF();
      this.i = paramObjectInput.readUTF();
      this.j = paramObjectInput.readUTF();
      this.k = paramObjectInput.readUTF();
    }
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.p != null)
    {
      str = this.p;
      paramObjectOutput.writeUTF(str);
      if (this.q == null) {
        break label134;
      }
      str = this.q;
      label36:
      paramObjectOutput.writeUTF(str);
      if (this.e > 5)
      {
        if (this.r == null) {
          break label140;
        }
        str = this.r;
        label63:
        paramObjectOutput.writeUTF(str);
        if (this.i == null) {
          break label146;
        }
        str = this.i;
        label82:
        paramObjectOutput.writeUTF(str);
        if (this.j == null) {
          break label152;
        }
        str = this.j;
        label101:
        paramObjectOutput.writeUTF(str);
        if (this.k == null) {
          break label158;
        }
      }
    }
    label134:
    label140:
    label146:
    label152:
    label158:
    for (String str = this.k;; str = "")
    {
      paramObjectOutput.writeUTF(str);
      return;
      str = "";
      break;
      str = "";
      break label36;
      str = "";
      break label63;
      str = "";
      break label82;
      str = "";
      break label101;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "pavideo");
    paramXmlSerializer.attribute(null, "cover", this.p);
    paramXmlSerializer.attribute(null, "src", this.q);
    if (this.e > 5)
    {
      paramXmlSerializer.attribute(null, "video_info", this.r);
      if (!TextUtils.isEmpty(this.i)) {
        paramXmlSerializer.attribute(null, "index", this.i);
      }
      if (!TextUtils.isEmpty(this.j)) {
        paramXmlSerializer.attribute(null, "index_name", this.j);
      }
      if (!TextUtils.isEmpty(this.k)) {
        paramXmlSerializer.attribute(null, "index_type", this.k);
      }
    }
    paramXmlSerializer.endTag(null, "pavideo");
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    do
    {
      return true;
      this.p = paramStructMsgNode.a("cover");
      this.q = paramStructMsgNode.a("src");
    } while (this.e <= 5);
    this.r = paramStructMsgNode.a("video_info");
    this.i = paramStructMsgNode.a("index");
    this.j = paramStructMsgNode.a("index_name");
    this.k = paramStructMsgNode.a("index_type");
    return true;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemPAVideo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */