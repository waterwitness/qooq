package com.tencent.mobileqq.troop.text;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.DynamicDrawableSpan;
import android.util.SparseIntArray;
import android.widget.EditText;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.text.EmotcationConstants;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import vof;

public class AtTroopMemberSpan
  extends DynamicDrawableSpan
{
  private static final String jdField_a_of_type_JavaLangString = AtTroopMemberSpan.class.getSimpleName();
  private static final String f = "@";
  private static final String g = " ";
  private static final String h = "...";
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString = "";
  private String c = "";
  private String d = "";
  private String e = "";
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  private AtTroopMemberSpan(Context paramContext, String paramString1, String paramString2, String paramString3, int paramInt, Paint paramPaint, boolean paramBoolean)
  {
    super(0);
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.c = a(String.format("%s%s", new Object[] { "@", paramString2 }));
    if (paramBoolean) {}
    for (this.d = this.c;; this.d = a(String.format("%s%s", new Object[] { "@", paramString3 })))
    {
      this.jdField_b_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      a(paramPaint);
      return;
    }
  }
  
  public static SpannableString a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, EditText paramEditText, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramEditText == null)) {
      return null;
    }
    AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramEditText.getEditableText().getSpans(0, paramEditText.getEditableText().toString().length(), AtTroopMemberSpan.class);
    int i = 0;
    while (i < arrayOfAtTroopMemberSpan.length)
    {
      if (arrayOfAtTroopMemberSpan[i].jdField_b_of_type_JavaLangString.contentEquals(paramString2)) {
        return null;
      }
      i += 1;
    }
    i = paramEditText.getWidth();
    int j = paramEditText.getPaddingLeft();
    int k = paramEditText.getPaddingRight();
    try
    {
      paramQQAppInterface = a(paramQQAppInterface, paramContext, paramString1, paramString2, paramString3, paramBoolean1, i - j - k, paramEditText.getPaint(), paramBoolean2);
      if (paramQQAppInterface == null) {
        return null;
      }
    }
    catch (OutOfMemoryError paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface = null;
      }
      paramContext = paramQQAppInterface.c;
      paramString1 = new SpannableString(paramContext + " ");
      paramString1.setSpan(paramQQAppInterface, 0, paramContext.length(), 33);
    }
    return paramString1;
  }
  
  private static AtTroopMemberSpan a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, int paramInt, Paint paramPaint, boolean paramBoolean2)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramInt <= 0)) {
      return null;
    }
    String str1 = "";
    if (paramBoolean2) {
      if ((!paramBoolean1) && (!paramString2.equalsIgnoreCase("0")))
      {
        String str2 = ContactUtils.e(paramQQAppInterface, paramString1, paramString2);
        paramQQAppInterface = str2;
        paramString1 = str1;
        if (TextUtils.isEmpty(str2))
        {
          paramQQAppInterface = str2;
          paramString1 = str1;
          if (!TextUtils.isEmpty(paramString3))
          {
            paramQQAppInterface = paramString3;
            paramString1 = str1;
          }
        }
      }
    }
    while (TextUtils.isEmpty(paramQQAppInterface))
    {
      return null;
      paramQQAppInterface = paramString3;
      paramString1 = str1;
      continue;
      if (!paramString2.equalsIgnoreCase("0"))
      {
        str1 = paramString3;
        if (TextUtils.isEmpty(paramString3)) {
          str1 = ContactUtils.c(paramQQAppInterface, paramString1, paramString2);
        }
        paramString1 = ContactUtils.c(paramQQAppInterface, paramString2, true);
        paramQQAppInterface = str1;
      }
      else
      {
        paramString1 = paramString3;
        paramQQAppInterface = paramString3;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("_At_Me_DISC", 2, " memUin:" + paramString2 + " troopMemName:" + Utils.a(paramQQAppInterface) + " isTroop:" + paramBoolean2);
    }
    return new AtTroopMemberSpan(paramContext, paramString2, paramQQAppInterface, paramString1, paramInt, paramPaint, paramBoolean2);
  }
  
  public static String a(Editable paramEditable, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramEditable == null)) {
      return "";
    }
    paramArrayList.clear();
    StringBuffer localStringBuffer = new StringBuffer(paramEditable.toString());
    int m = localStringBuffer.length();
    AtTroopMemberSpan[] arrayOfAtTroopMemberSpan = (AtTroopMemberSpan[])paramEditable.getSpans(0, m - 1, AtTroopMemberSpan.class);
    if (arrayOfAtTroopMemberSpan.length == 0) {
      return localStringBuffer.toString();
    }
    if (arrayOfAtTroopMemberSpan.length > 1) {
      Arrays.sort(arrayOfAtTroopMemberSpan, new vof(paramEditable));
    }
    int i = 0;
    int n;
    int i1;
    for (int j = 0; i < arrayOfAtTroopMemberSpan.length; j = k)
    {
      AtTroopMemberSpan localAtTroopMemberSpan = arrayOfAtTroopMemberSpan[i];
      n = paramEditable.getSpanStart(localAtTroopMemberSpan) + j;
      i1 = paramEditable.getSpanEnd(localAtTroopMemberSpan) + j;
      try
      {
        localStringBuffer.replace(n, i1, localAtTroopMemberSpan.d);
        MessageForText.AtTroopMemberInfo localAtTroopMemberInfo = new MessageForText.AtTroopMemberInfo();
        localAtTroopMemberInfo.uin = Long.valueOf(localAtTroopMemberSpan.jdField_b_of_type_JavaLangString).longValue();
        if ((localAtTroopMemberSpan.jdField_b_of_type_JavaLangString != null) && (localAtTroopMemberSpan.jdField_b_of_type_JavaLangString.equalsIgnoreCase("0"))) {
          localAtTroopMemberInfo.flag = 1;
        }
        localAtTroopMemberInfo.startPos = ((short)n);
        localAtTroopMemberInfo.textLen = ((short)localAtTroopMemberSpan.d.length());
        paramArrayList.add(localAtTroopMemberInfo);
        k = j + (localAtTroopMemberInfo.textLen - (i1 - n));
      }
      catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
      {
        for (;;)
        {
          int k = j;
          if (QLog.isColorLevel())
          {
            QLog.e(jdField_a_of_type_JavaLangString, 2, String.format(localStringBuffer.toString() + ",IndexOutOfBoundsException, convertToSendMsg, start:%d | end:%d | msgBLen:%d", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(m) }));
            k = j;
          }
        }
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static String a(CharSequence paramCharSequence)
  {
    paramCharSequence = new StringBuffer(paramCharSequence);
    int i = 0;
    if (i < paramCharSequence.length())
    {
      int k = paramCharSequence.codePointAt(i);
      int j;
      if ((k == 20) && (i < paramCharSequence.length() - 1))
      {
        paramCharSequence.delete(i, i + 2);
        j = i - 1;
      }
      do
      {
        i = j + 1;
        break;
        j = i;
      } while (EmotcationConstants.a.get(k, -1) < 0);
      if ((k > 65535) && (paramCharSequence.length() >= i + 2)) {
        paramCharSequence.delete(i, i + 2);
      }
      for (;;)
      {
        j = i - 1;
        break;
        paramCharSequence.delete(i, i + 1);
      }
    }
    return paramCharSequence.toString();
  }
  
  public static StringBuilder a(QQAppInterface paramQQAppInterface, StringBuilder paramStringBuilder, String paramString1, String paramString2)
  {
    j = 0;
    if ((TextUtils.isEmpty(paramStringBuilder.toString())) || (TextUtils.isEmpty(paramString2)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString + "_At_Me_DISC", 2, "Recv replaceAtMsgByMarkName return discUin:" + paramString2);
      }
      paramString1 = paramStringBuilder;
    }
    do
    {
      return paramString1;
      try
      {
        localJSONArray = new JSONArray(paramString1);
        m = localJSONArray.length();
        i = 0;
      }
      catch (JSONException paramQQAppInterface)
      {
        try
        {
          JSONArray localJSONArray;
          int m;
          int i;
          JSONObject localJSONObject = localJSONArray.getJSONObject(i);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int i1 = (byte)localJSONObject.optInt("flag", 1);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          String str = localJSONObject.optString("uin");
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int i2 = localJSONObject.optInt("startPos", 0);
          paramString1 = paramStringBuilder;
          localStringBuilder = paramStringBuilder;
          int n = localJSONObject.optInt("textLen", 0);
          int k = j;
          paramString1 = paramStringBuilder;
          if (i1 == 0)
          {
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            str = "@" + ContactUtils.c(paramQQAppInterface, paramString2, str);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            paramStringBuilder = paramStringBuilder.replace(i2 + j, i2 + n + j, str);
            paramString1 = paramStringBuilder;
            localStringBuilder = paramStringBuilder;
            k = str.length();
            k = j + (k - n);
            paramString1 = paramStringBuilder;
          }
          i += 1;
          j = k;
          paramStringBuilder = paramString1;
        }
        catch (Exception paramQQAppInterface)
        {
          StringBuilder localStringBuilder;
          for (;;) {}
        }
        catch (JSONException paramQQAppInterface)
        {
          for (;;) {}
        }
        paramQQAppInterface = paramQQAppInterface;
        localStringBuilder = paramStringBuilder;
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_1 ", paramQQAppInterface);
        return localStringBuilder;
      }
      catch (Exception paramQQAppInterface)
      {
        paramString1 = paramStringBuilder;
        QLog.e("_At_Me_DISC", 1, "replaceAtMsgByMarkName_2", paramQQAppInterface);
        return paramString1;
      }
      paramString1 = paramStringBuilder;
    } while (i >= m);
    paramString1 = paramStringBuilder;
    localStringBuilder = paramStringBuilder;
  }
  
  public static void a(int paramInt, ArrayList paramArrayList, ChatMessage paramChatMessage)
  {
    if ((paramInt == 3000) && (paramArrayList.size() > 0)) {}
    try
    {
      JSONArray localJSONArray = new JSONArray();
      paramArrayList = paramArrayList.iterator();
      paramInt = 0;
      while (paramArrayList.hasNext())
      {
        localJSONArray.put(paramInt, ((MessageForText.AtTroopMemberInfo)paramArrayList.next()).toJsonObject());
        paramInt += 1;
      }
      paramChatMessage.saveExtInfoToExtStr("disc_at_info_list", localJSONArray.toString());
      return;
    }
    catch (JSONException paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
  }
  
  private void a(Paint paramPaint)
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null) {
      return;
    }
    b(paramPaint);
    Object localObject = paramPaint.getFontMetrics();
    float f1 = -((Paint.FontMetrics)localObject).top;
    int i = (int)Math.ceil(((Paint.FontMetrics)localObject).bottom - ((Paint.FontMetrics)localObject).top);
    localObject = new RectF(0.0F, ((Paint.FontMetrics)localObject).ascent - ((Paint.FontMetrics)localObject).top, this.jdField_a_of_type_Int - 2, ((Paint.FontMetrics)localObject).descent + f1);
    Bitmap localBitmap = Bitmap.createBitmap(this.jdField_a_of_type_Int, i, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap);
    i = paramPaint.getColor();
    paramPaint.setColor(-4331268);
    localCanvas.drawRect((RectF)localObject, paramPaint);
    paramPaint.setColor(i);
    localCanvas.drawText(this.e, 0.0F, f1, paramPaint);
    localCanvas.save(31);
    localCanvas.restore();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), localBitmap);
    i = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    paramPaint = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    int j = this.jdField_a_of_type_Int;
    if (i > 0) {}
    for (;;)
    {
      paramPaint.setBounds(0, 0, j, i);
      return;
      i = 0;
    }
  }
  
  private void b(Paint paramPaint)
  {
    if (this.jdField_a_of_type_Int != -1) {}
    for (;;)
    {
      return;
      float f1 = paramPaint.measureText(" ");
      this.jdField_a_of_type_Int = ((int)Math.ceil(paramPaint.measureText(this.c) + f1 * 2.0F));
      if (this.jdField_a_of_type_Int <= this.jdField_b_of_type_Int)
      {
        this.e = String.format("%s%s%s", new Object[] { " ", this.c, " " });
        return;
      }
      int i = this.c.length() - 1;
      float f2 = paramPaint.measureText("...");
      while (i > 0)
      {
        this.jdField_a_of_type_Int = ((int)Math.ceil(paramPaint.measureText(this.c, 0, i) + f2 + f1 * 2.0F));
        if (this.jdField_a_of_type_Int <= this.jdField_b_of_type_Int)
        {
          this.e = String.format("%s%s%s%s", new Object[] { " ", this.c.substring(0, i), "...", " " });
          return;
        }
        i -= 1;
      }
    }
  }
  
  public Drawable getDrawable()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\troop\text\AtTroopMemberSpan.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */