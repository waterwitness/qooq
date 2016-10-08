package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView.ScaleType;
import com.tencent.biz.pubaccount.ViewCache;
import com.tencent.biz.pubaccount.util.PubAccountHttpDownloader;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgNode;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.CustomScaleType;
import com.tencent.mobileqq.widget.PAHighLightImageView;
import com.tencent.mobileqq.widget.PAImageView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONObject;
import org.xmlpull.v1.XmlSerializer;
import uwa;

public class StructMsgItemCover
  extends AbsStructMsgElement
{
  public static int k;
  public static int l = 2;
  public static int m = 3;
  private static final String q;
  private URLDrawableDownListener.Adapter a;
  public boolean a;
  public int i;
  public int j;
  public int n = m;
  public String o;
  public String p;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    q = StructMsgItemCover.class.getSimpleName();
    jdField_k_of_type_Int = 1;
  }
  
  public StructMsgItemCover()
  {
    this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter = new uwa(this);
    this.jdField_a_of_type_JavaLangString = "picture";
    this.e = 9;
  }
  
  public StructMsgItemCover(String paramString)
  {
    this();
    this.o = paramString;
  }
  
  public StructMsgItemCover(String paramString1, String paramString2)
  {
    this();
    this.o = paramString1;
    this.p = paramString2;
  }
  
  public static Bitmap a(Drawable paramDrawable)
  {
    try
    {
      int i1 = paramDrawable.getIntrinsicWidth();
      if (paramDrawable.getOpacity() != -1) {}
      for (Object localObject = Bitmap.Config.ARGB_8888;; localObject = Bitmap.Config.RGB_565)
      {
        localObject = Bitmap.createBitmap(i1, i1, (Bitmap.Config)localObject);
        Canvas localCanvas = new Canvas((Bitmap)localObject);
        paramDrawable.setBounds(0, 0, i1, i1);
        paramDrawable.draw(localCanvas);
        paramDrawable = ImageUtil.a((Bitmap)localObject, i1, i1, i1);
        ((Bitmap)localObject).recycle();
        return paramDrawable;
      }
      return null;
    }
    catch (Exception paramDrawable) {}
  }
  
  private URLDrawable a(String paramString, int paramInt1, int paramInt2, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    try
    {
      URL localURL = new URL(paramString);
      paramString = URLDrawable.URLDrawableOptions.obtain();
      paramString.mRequestWidth = paramInt1;
      paramString.mRequestHeight = paramInt2;
      paramString.mLoadingDrawable = paramDrawable1;
      paramString.mFailedDrawable = paramDrawable2;
      paramString.mPlayGifImage = paramBoolean1;
      paramString.mGifRoundCorner = 0.0F;
      paramString.mNeedCheckNetType = paramBoolean2;
      paramString.mReportFlag = 1;
      paramString.mExtraInfo = paramObject;
      return URLDrawable.getDrawable(localURL, paramString);
    }
    catch (MalformedURLException paramDrawable1)
    {
      throw new IllegalArgumentException("illegal url format: " + paramString);
    }
  }
  
  public View a(Context paramContext, View paramView, Bundle paramBundle)
  {
    return a(paramContext, paramView, false, paramBundle);
  }
  
  public View a(Context paramContext, View paramView, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (QLog.isColorLevel()) {
      QLog.d("[@]", 2, "StructMsgItemCover createView start! mUrlString = " + this.o);
    }
    boolean bool;
    Resources localResources;
    int i1;
    Object localObject2;
    String str;
    if (paramBundle != null)
    {
      bool = paramBundle.getBoolean("pa_should_change");
      localResources = paramContext.getResources();
      i1 = localResources.getDisplayMetrics().widthPixels;
      localObject2 = null;
      try
      {
        paramBundle = ViewCache.a().a(localResources, 2130843354);
        localObject2 = paramBundle;
      }
      catch (OutOfMemoryError paramBundle)
      {
        for (;;)
        {
          Object localObject1;
          int i2;
          Object localObject3;
          continue;
          paramContext = null;
          paramView = str;
        }
      }
      if ((paramView != null) && ((paramView instanceof PAImageView)))
      {
        paramBundle = (PAImageView)paramView;
        localObject1 = paramView;
        paramBundle.setTag(this);
        str = this.o;
        if (!TextUtils.isEmpty(str)) {
          break label301;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,url = " + str);
        }
        paramBundle.setImageDrawable((Drawable)localObject2);
        paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (!bool) {
          break label287;
        }
        paramBundle.setBackgroundColor(Color.parseColor("#dddfe2"));
      }
      for (;;)
      {
        label191:
        if ((this.c != null) && (!this.c.equals("")))
        {
          ((View)localObject1).setClickable(true);
          ((View)localObject1).setOnClickListener(this);
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView end!");
        }
        return (View)localObject1;
        localObject1 = new PAHighLightImageView(paramContext);
        ((PAImageView)localObject1).setId(2131296359);
        ((PAImageView)localObject1).setContentDescription(localResources.getString(2131367270));
        ((PAImageView)localObject1).setDisplayRuleDef(CustomScaleType.a);
        paramBundle = (Bundle)localObject1;
        break;
        label287:
        paramBundle.setBackgroundColor(Color.parseColor("#dddfe4"));
        continue;
        label301:
        if ((str.startsWith("http://")) || (str.startsWith("https://")) || (str.startsWith("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2)))) {
          break label756;
        }
        try
        {
          if (!str.startsWith("mqqapi://card")) {
            break label635;
          }
          i1 = str.lastIndexOf("&uin=");
          if (i1 != -1) {
            break label559;
          }
          if (QLog.isColorLevel()) {
            QLog.e(q, 2, "createView, error: index is -1");
          }
          paramBundle.setImageDrawable(ImageUtil.a());
          return (View)localObject1;
        }
        catch (MalformedURLException paramContext)
        {
          i1 = 0;
        }
        label404:
        if (QLog.isColorLevel()) {
          QLog.e(q, 2, "createView, error: " + paramContext.getMessage());
        }
        paramBundle.setImageDrawable(ImageUtil.a());
        paramContext = null;
        if ((paramContext == null) || (paramContext.getStatus() != 1)) {
          break label1501;
        }
        if (QLog.isColorLevel()) {
          QLog.d("[@]", 2, "StructMsgItemCover createView ,set null");
        }
        paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
        label485:
        if (paramBoolean) {
          paramBundle.setBackgroundDrawable(null);
        }
        if ((paramContext == null) || (!paramBoolean)) {
          break label1528;
        }
        i2 = i1;
        if (i1 == 0) {
          i2 = paramContext.getIntrinsicWidth();
        }
        paramContext.setTag(URLDrawableDecodeHandler.a(i2, i2, i2));
        paramContext.setDecodeHandler(URLDrawableDecodeHandler.e);
        paramBundle.setImageDrawable(paramContext);
        if (paramContext.getStatus() != 1) {
          paramContext.restartDownload();
        }
      }
      label559:
      paramContext = str.substring("&uin=".length() + i1);
      if (localObject1 != null)
      {
        paramView = ((View)localObject1).getContext();
        if ((paramView instanceof BaseActivity))
        {
          paramView = ((BaseActivity)paramView).app;
          localObject2 = ImageUtil.a();
          paramBundle.setImageDrawable(FaceDrawable.a(paramView, 1, paramContext, 3, (Drawable)localObject2, (Drawable)localObject2));
          return (View)localObject1;
        }
      }
      paramBundle.setImageDrawable(ImageUtil.a());
      return (View)localObject1;
      label635:
      if (str.startsWith("troop_notice"))
      {
        paramBundle.setImageResource(2130840165);
        return (View)localObject1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "StructMsgItemCover createView ,begin decode");
      }
      paramContext = new File(str).toURL().toString();
      for (;;)
      {
        try
        {
          if (this.n == jdField_k_of_type_Int)
          {
            i2 = AIOUtils.a(70.0F, localResources);
            i1 = i2;
          }
        }
        catch (MalformedURLException paramContext) {}
        try
        {
          paramContext = URLDrawable.getDrawable(paramContext, i1, i1, (Drawable)localObject2, (Drawable)localObject2, true);
        }
        catch (MalformedURLException paramContext) {}
        if (this.n != l) {
          break label1558;
        }
        i2 = AIOUtils.a(140.0F, localResources);
        i1 = i2;
      }
      label756:
      localObject3 = null;
      if (str.startsWith("http://p.qlogo.cn/gh/"))
      {
        i2 = str.lastIndexOf("gh/");
        paramContext = str.substring("gh/".length() + i2).split("/")[0];
        if (!TextUtils.isEmpty(paramContext))
        {
          paramView = ((View)localObject1).getContext();
          if ((paramView instanceof BaseActivity))
          {
            paramView = ((BaseActivity)paramView).app.a(paramContext, (byte)3, false, false);
            paramContext = paramView;
            if (paramView == null) {
              paramContext = ImageUtil.f();
            }
            paramBundle.setImageDrawable(new BitmapDrawable(paramContext));
            return (View)localObject1;
          }
          paramBundle.setImageDrawable(ImageUtil.a());
          return (View)localObject1;
        }
        paramContext = null;
        paramView = str;
      }
    }
    for (;;)
    {
      label880:
      if (this.n == jdField_k_of_type_Int)
      {
        paramBundle.setScaleType(ImageView.ScaleType.CENTER_CROP);
        i1 = AIOUtils.a(70.0F, localResources);
        label908:
        if (!bool) {
          break label1487;
        }
        paramBundle.setBackgroundColor(Color.parseColor("#dddfe2"));
      }
      for (;;)
      {
        paramContext = a(paramView, i1, i1, (Drawable)localObject2, (Drawable)localObject2, true, true, paramContext);
        paramContext.setAutoDownload(true);
        if (paramContext.getStatus() == 2) {
          paramContext.restartDownload();
        }
        break;
        if (str.startsWith("http://s.p.qq.com/pub/get_face?img_type=3&uin="))
        {
          i1 = str.lastIndexOf("&uin=");
          paramContext = str.substring("&uin=".length() + i1);
          paramView = ((View)localObject1).getContext();
          if ((paramView instanceof BaseActivity))
          {
            paramBundle.setImageDrawable(((BaseActivity)paramView).app.b(paramContext));
            return (View)localObject1;
          }
          paramBundle.setImageDrawable(ImageUtil.a());
          return (View)localObject1;
        }
        if (str.startsWith("http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".substring(0, "http://sqimg.qq.com/qq_product_operations/flower/images/aio-msg/android/%s".length() - 2)))
        {
          paramContext = new ColorDrawable(0);
          paramBundle.setImageDrawable(URLDrawable.getDrawable(str, paramContext, paramContext));
          return (View)localObject1;
        }
        if (str.startsWith("http://imgplat.store.qq.com/bqq_qfpic/520520"))
        {
          paramBoolean = true;
          this.jdField_a_of_type_Boolean = true;
          paramContext = null;
          paramView = str;
          break label880;
        }
        if ((this.p != null) && (this.p.equals("1")))
        {
          paramBoolean = true;
          this.jdField_a_of_type_Boolean = true;
          paramContext = null;
          paramView = str;
          break label880;
        }
        if (str.startsWith("http://qqpublic.qpic.cn"))
        {
          paramView = str;
          try
          {
            if (new URL(str).getQuery() != null)
            {
              paramContext = "&spec=screen";
              paramView = str;
              if (this.n == jdField_k_of_type_Int) {
                paramContext = "&spec=small";
              }
            }
            for (;;)
            {
              paramView = str;
              new String(str);
              paramView = str;
              paramContext = str + paramContext;
              paramView = paramContext;
              str = PubAccountHttpDownloader.a(paramContext, 0).toString();
              paramView = str;
              paramContext = (Context)localObject3;
              if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
                break;
              }
              paramView = str;
              paramContext = (Context)localObject3;
              if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) {
                break;
              }
              paramView = str;
              paramContext = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
              break;
              paramView = str;
              if (this.n == l)
              {
                paramContext = "&spec=middle";
                continue;
                paramContext = "?spec=screen";
                paramView = str;
                if (this.n == jdField_k_of_type_Int)
                {
                  paramContext = "?spec=small";
                }
                else
                {
                  paramView = str;
                  if (this.n == l) {
                    paramContext = "?spec=middle";
                  }
                }
              }
            }
            if (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg == null) {
              break label1550;
            }
          }
          catch (MalformedURLException paramContext)
          {
            throw new IllegalArgumentException("illegal url format: " + paramView);
          }
        }
        if ((this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message == null) || (this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message.istroop != 1008)) {
          break label1550;
        }
        new String(str);
        paramView = PubAccountHttpDownloader.a(str, 0).toString();
        paramContext = this.jdField_a_of_type_ComTencentMobileqqStructmsgAbsStructMsg.message;
        break label880;
        if (this.n == l)
        {
          paramBundle.setScaleType(ImageView.ScaleType.CENTER);
          i1 = AIOUtils.a(140.0F, localResources);
          break label908;
        }
        paramBundle.setScaleType(ImageView.ScaleType.CENTER);
        break label908;
        label1487:
        paramBundle.setBackgroundColor(Color.parseColor("#dddfe4"));
      }
      label1501:
      if (QLog.isColorLevel()) {
        QLog.d("[@]", 2, "StructMsgItemCover createView ,set listener");
      }
      paramBundle.setURLDrawableDownListener(this.jdField_a_of_type_ComTencentImageURLDrawableDownListener$Adapter);
      break label485;
      label1528:
      paramBundle.setImageDrawable(paramContext);
      break label191;
      break label404;
      break label404;
      label1550:
      label1558:
      bool = false;
      break;
      paramView = str;
    }
  }
  
  StructMsgForGeneralShare a(View paramView)
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
    return "Cover";
  }
  
  public void a(View paramView, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    try
    {
      localObject2 = AIOUtils.a(paramView);
      localObject1 = localObject2;
    }
    catch (ClassCastException localClassCastException)
    {
      Object localObject2;
      for (;;) {}
    }
    if (localObject1 == null) {}
    do
    {
      Object localObject3;
      do
      {
        return;
        localObject3 = ((ChatMessage)localObject1).getExtInfoFromExtStr("gdt_msgClick");
      } while ((TextUtils.isEmpty((CharSequence)localObject3)) || (!this.o.endsWith("gif")));
      localObject1 = "0";
      localObject2 = ((FragmentActivity)paramView.getContext()).getChatFragment().a();
      try
      {
        localObject3 = new JSONObject((String)localObject3);
        if (((JSONObject)localObject3).has("ad_id")) {
          localObject1 = ((JSONObject)localObject3).getString("ad_id");
        }
      }
      catch (Exception localException)
      {
        String str;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(q, 2, "parse ad_id error");
          }
          str = "0";
        }
        ReportController.b((QQAppInterface)localObject2, "P_CliOper", "Pb_account_lifeservice", "", "0X8005D93", "0X8005D93", paramInt2, 1, paramInt1, str, String.valueOf(paramView.msgId), "1", "");
        return;
      }
      paramView = a(paramView);
      if (paramView != null) {
        break label155;
      }
    } while (!QLog.isColorLevel());
    QLog.d(q, 2, "StructMsgForGeneralShare == NULL");
  }
  
  public void a(ObjectInput paramObjectInput)
  {
    super.a(paramObjectInput);
    this.o = paramObjectInput.readUTF();
    if (this.e <= 3) {}
    do
    {
      do
      {
        return;
        this.c = paramObjectInput.readUTF();
        this.b = paramObjectInput.readUTF();
      } while (this.e <= 5);
      this.jdField_i_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_j_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_k_of_type_JavaLangString = paramObjectInput.readUTF();
      this.jdField_i_of_type_Int = paramObjectInput.readInt();
      this.jdField_j_of_type_Int = paramObjectInput.readInt();
    } while (this.e <= 8);
    this.p = paramObjectInput.readUTF();
  }
  
  public void a(ObjectOutput paramObjectOutput)
  {
    super.a(paramObjectOutput);
    if (this.o == null)
    {
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.e > 3) {
        break label40;
      }
    }
    label40:
    label69:
    label95:
    label113:
    label131:
    do
    {
      do
      {
        return;
        str = this.o;
        break;
        if (this.c != null) {
          break label186;
        }
        str = "";
        paramObjectOutput.writeUTF(str);
        if (this.b != null) {
          break label194;
        }
        str = "";
        paramObjectOutput.writeUTF(str);
      } while (this.e <= 5);
      if (this.jdField_i_of_type_JavaLangString != null) {
        break label202;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_j_of_type_JavaLangString != null) {
        break label210;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      if (this.jdField_k_of_type_JavaLangString != null) {
        break label218;
      }
      str = "";
      paramObjectOutput.writeUTF(str);
      paramObjectOutput.writeInt(this.jdField_i_of_type_Int);
      paramObjectOutput.writeInt(this.jdField_j_of_type_Int);
    } while (this.e <= 8);
    if (this.p == null) {}
    for (String str = "";; str = this.p)
    {
      paramObjectOutput.writeUTF(str);
      return;
      label186:
      str = this.c;
      break;
      label194:
      str = this.b;
      break label69;
      label202:
      str = this.jdField_i_of_type_JavaLangString;
      break label95;
      label210:
      str = this.jdField_j_of_type_JavaLangString;
      break label113;
      label218:
      str = this.jdField_k_of_type_JavaLangString;
      break label131;
    }
  }
  
  public void a(XmlSerializer paramXmlSerializer)
  {
    paramXmlSerializer.startTag(null, "picture");
    if (this.o == null) {}
    for (String str = "";; str = this.o)
    {
      paramXmlSerializer.attribute(null, "cover", str);
      if (this.e > 3)
      {
        if (!TextUtils.isEmpty(this.c)) {
          paramXmlSerializer.attribute(null, "action", this.c);
        }
        if (!TextUtils.isEmpty(this.b)) {
          paramXmlSerializer.attribute(null, "url", this.b);
        }
        if (this.e > 5)
        {
          if (!TextUtils.isEmpty(this.jdField_i_of_type_JavaLangString)) {
            paramXmlSerializer.attribute(null, "index", this.jdField_i_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty(this.jdField_j_of_type_JavaLangString)) {
            paramXmlSerializer.attribute(null, "index_name", this.jdField_j_of_type_JavaLangString);
          }
          if (!TextUtils.isEmpty(this.jdField_k_of_type_JavaLangString)) {
            paramXmlSerializer.attribute(null, "index_type", this.jdField_k_of_type_JavaLangString);
          }
          paramXmlSerializer.attribute(null, "w", String.valueOf(this.jdField_i_of_type_Int));
          paramXmlSerializer.attribute(null, "h", String.valueOf(this.jdField_j_of_type_Int));
          if ((this.e > 8) && (!TextUtils.isEmpty(this.p))) {
            paramXmlSerializer.attribute(null, "needRoundView", this.p);
          }
        }
      }
      paramXmlSerializer.endTag(null, "picture");
      return;
    }
  }
  
  public boolean a(StructMsgNode paramStructMsgNode)
  {
    if (paramStructMsgNode == null) {}
    String str;
    label18:
    do
    {
      do
      {
        return true;
        str = paramStructMsgNode.a("cover");
        if (str == null) {
          break;
        }
        this.o = str;
      } while (this.e <= 3);
      this.c = paramStructMsgNode.a("action");
      this.b = paramStructMsgNode.a("url");
    } while (this.e <= 5);
    this.jdField_i_of_type_JavaLangString = paramStructMsgNode.a("index");
    this.jdField_j_of_type_JavaLangString = paramStructMsgNode.a("index_name");
    this.jdField_k_of_type_JavaLangString = paramStructMsgNode.a("index_type");
    for (;;)
    {
      try
      {
        str = paramStructMsgNode.a("w");
        if (str != null) {
          continue;
        }
        i1 = 0;
        this.jdField_i_of_type_Int = i1;
        str = paramStructMsgNode.a("h");
        if (str != null) {
          continue;
        }
        i1 = 0;
        this.jdField_j_of_type_Int = i1;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        int i1;
        this.jdField_i_of_type_Int = 0;
        this.jdField_j_of_type_Int = 0;
        continue;
      }
      if (this.e <= 8) {
        break;
      }
      this.p = paramStructMsgNode.a("needRoundView");
      return true;
      str = "";
      break label18;
      i1 = Integer.parseInt(str);
      continue;
      i1 = Integer.parseInt(str);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemCover.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */