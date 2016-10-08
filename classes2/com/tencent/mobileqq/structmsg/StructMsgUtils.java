package com.tencent.mobileqq.structmsg;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils.TruncateAt;
import android.util.StateSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

public class StructMsgUtils
{
  public static final int a = 4;
  
  public StructMsgUtils()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public static int a(String paramString)
  {
    int i = 0;
    if (paramString != null) {
      paramString.trim();
    }
    try
    {
      i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  public static long a(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      paramString.trim();
    }
    try
    {
      l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public static StateListDrawable a(Resources paramResources, int paramInt, float[] paramArrayOfFloat)
  {
    GradientDrawable[] arrayOfGradientDrawable = new GradientDrawable[2];
    int k = Color.red(paramInt);
    int i = Color.green(paramInt);
    int j = Color.blue(paramInt);
    paramInt = k;
    k = 0;
    if (k < arrayOfGradientDrawable.length)
    {
      arrayOfGradientDrawable[k] = new GradientDrawable();
      arrayOfGradientDrawable[k].setShape(0);
      int m = paramInt - (k << 5);
      paramInt = m;
      if (m < 0) {
        paramInt = 0;
      }
      m = i - (k << 5);
      i = m;
      if (m < 0) {
        i = 0;
      }
      m = j - (k << 5);
      j = m;
      if (m < 0) {
        j = 0;
      }
      arrayOfGradientDrawable[k].setColor(Color.rgb(paramInt, i, j));
      if (paramArrayOfFloat != null) {
        arrayOfGradientDrawable[k].setCornerRadii(paramArrayOfFloat);
      }
      for (;;)
      {
        k += 1;
        break;
        arrayOfGradientDrawable[k].setCornerRadius(AIOUtils.a(4.0F, paramResources));
      }
    }
    paramResources = new StateListDrawable();
    paramArrayOfFloat = arrayOfGradientDrawable[1];
    paramResources.addState(new int[] { 16842919, 16842910 }, paramArrayOfFloat);
    paramResources.addState(StateSet.WILD_CARD, arrayOfGradientDrawable[0]);
    return paramResources;
  }
  
  public static View a(Context paramContext, View paramView, long paramLong, boolean paramBoolean)
  {
    RelativeLayout localRelativeLayout = new RelativeLayout(paramContext);
    localRelativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    localRelativeLayout.addView(paramView);
    paramView = a(paramContext, paramLong, paramBoolean);
    paramContext = new RelativeLayout.LayoutParams(-1, AIOUtils.a(50.0F, paramContext.getResources()));
    paramContext.addRule(12, -1);
    localRelativeLayout.addView(paramView, paramContext);
    return localRelativeLayout;
  }
  
  public static TextView a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    TextView localTextView = new TextView(paramContext);
    localTextView.setText(TimeFormatterUtils.a(paramContext, 3, 1000L * paramLong));
    localTextView.setMaxLines(1);
    localTextView.setEllipsize(TextUtils.TruncateAt.END);
    localTextView.setTextColor(-1275068417);
    localTextView.setTextSize(2, 12.0F);
    localTextView.setBackgroundResource(2130838904);
    localTextView.setGravity(83);
    if (paramBoolean) {
      localTextView.setGravity(85);
    }
    int i = AIOUtils.a(20.0F, paramContext.getResources());
    localTextView.setPadding(i, 0, i, AIOUtils.a(13.0F, paramContext.getResources()));
    return localTextView;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    Inflater localInflater = new Inflater();
    localInflater.reset();
    localInflater.setInput(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte1 = new byte['Ѐ'];
      while (!localInflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte1, 0, localInflater.inflate(arrayOfByte1));
      }
      try
      {
        byte[] arrayOfByte2;
        localIOException3.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localIOException1.getMessage());
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localException.getMessage());
      }
      for (;;)
      {
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException3)
        {
          arrayOfByte2 = paramArrayOfByte;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsg", 2, localIOException3.getMessage());
          arrayOfByte2 = paramArrayOfByte;
          continue;
        }
        localInflater.end();
        return arrayOfByte2;
        arrayOfByte2 = localByteArrayOutputStream.toByteArray();
        paramArrayOfByte = arrayOfByte2;
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException2)
        {
          arrayOfByte2 = paramArrayOfByte;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, localIOException2.getMessage());
          arrayOfByte2 = paramArrayOfByte;
        }
      }
    }
    finally {}
  }
  
  public static byte[] a(byte[] paramArrayOfByte, int paramInt)
  {
    int i = paramArrayOfByte.length;
    Object localObject;
    if (paramInt == -1)
    {
      paramInt = paramArrayOfByte[0];
      localObject = new byte[i - 1];
      if (paramInt == 1)
      {
        System.arraycopy(paramArrayOfByte, 1, localObject, 0, i - 1);
        paramArrayOfByte = a((byte[])localObject);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        localObject = new String(paramArrayOfByte, 0, paramArrayOfByte.length);
        QLog.d("StructMsg", 2, "getStructMsgFromXmlBuff xmlStr:" + (String)localObject);
      }
      return paramArrayOfByte;
      System.arraycopy(paramArrayOfByte, 1, localObject, 0, i - 1);
      paramArrayOfByte = (byte[])localObject;
      continue;
      localObject = new byte[i];
      if (paramInt == 1)
      {
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
        paramArrayOfByte = a((byte[])localObject);
      }
      else
      {
        System.arraycopy(paramArrayOfByte, 0, localObject, 0, i);
        paramArrayOfByte = (byte[])localObject;
      }
    }
  }
  
  public static final byte[] b(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    byte[] arrayOfByte1 = new byte[0];
    Deflater localDeflater = new Deflater();
    localDeflater.reset();
    localDeflater.setInput(paramArrayOfByte);
    localDeflater.finish();
    localByteArrayOutputStream = new ByteArrayOutputStream(paramArrayOfByte.length);
    try
    {
      byte[] arrayOfByte3 = new byte['Ѐ'];
      while (!localDeflater.finished()) {
        localByteArrayOutputStream.write(arrayOfByte3, 0, localDeflater.deflate(arrayOfByte3));
      }
      try
      {
        byte[] arrayOfByte2;
        localByteArrayOutputStream.close();
        throw paramArrayOfByte;
      }
      catch (IOException localIOException1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, localIOException1.getMessage());
          }
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      if (QLog.isColorLevel()) {
        QLog.d("StructMsg", 2, localException.getMessage());
      }
      for (;;)
      {
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException3)
        {
          arrayOfByte2 = paramArrayOfByte;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("StructMsg", 2, localIOException3.getMessage());
          arrayOfByte2 = paramArrayOfByte;
          continue;
        }
        localDeflater.end();
        return arrayOfByte2;
        arrayOfByte3 = localByteArrayOutputStream.toByteArray();
        paramArrayOfByte = arrayOfByte3;
        try
        {
          localByteArrayOutputStream.close();
          arrayOfByte2 = paramArrayOfByte;
        }
        catch (IOException localIOException2)
        {
          arrayOfByte2 = paramArrayOfByte;
        }
        if (QLog.isColorLevel())
        {
          QLog.d("StructMsg", 2, localIOException2.getMessage());
          arrayOfByte2 = paramArrayOfByte;
        }
      }
    }
    catch (OutOfMemoryError paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte = paramArrayOfByte;
        if (QLog.isColorLevel()) {
          QLog.d("StructMsg", 2, paramArrayOfByte.getMessage());
        }
        try
        {
          localByteArrayOutputStream.close();
        }
        catch (IOException paramArrayOfByte)
        {
          if (QLog.isColorLevel()) {
            QLog.d("StructMsg", 2, paramArrayOfByte.getMessage());
          }
        }
      }
    }
    finally {}
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\structmsg\StructMsgUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */