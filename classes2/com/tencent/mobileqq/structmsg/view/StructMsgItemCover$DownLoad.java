package com.tencent.mobileqq.structmsg.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class StructMsgItemCover$DownLoad
  extends AsyncTask
{
  Context jdField_a_of_type_AndroidContentContext;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  
  public StructMsgItemCover$DownLoad(ImageView paramImageView, Context paramContext)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  protected Boolean a(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = new URL(paramVarArgs[0]);
      return Boolean.valueOf(false);
    }
    catch (Exception paramVarArgs)
    {
      try
      {
        paramVarArgs = (HttpURLConnection)paramVarArgs.openConnection();
        paramVarArgs.setDoInput(true);
        paramVarArgs.setConnectTimeout(30000);
        paramVarArgs.setReadTimeout(30000);
        paramVarArgs.connect();
        paramVarArgs = paramVarArgs.getInputStream();
        this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeStream(paramVarArgs);
        paramVarArgs.close();
        return Boolean.valueOf(true);
      }
      catch (Exception paramVarArgs)
      {
        return Boolean.valueOf(false);
      }
      catch (OutOfMemoryError paramVarArgs) {}
      paramVarArgs = paramVarArgs;
      return Boolean.valueOf(false);
    }
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (paramBoolean.booleanValue())
    {
      paramBoolean = StructMsgItemCover.a(new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), this.jdField_a_of_type_AndroidGraphicsBitmap));
      if (paramBoolean != null) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBoolean);
      }
    }
  }
  
  protected void onCancelled() {}
  
  protected void onPreExecute() {}
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\view\StructMsgItemCover$DownLoad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */