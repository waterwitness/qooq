package com.tencent.mobileqq.richstatus;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.widget.OffsetableImageSpan;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class RichStatus
  implements Serializable, Cloneable
{
  public static final int ACTION_COLOR_NORMAL = -8947849;
  public static final int ACTION_COLOR_PRESSED = -2039584;
  public static final float ACTION_SPAN_RESIZE_FACTOR = 1.1F;
  public static final String EVENT_SPAN_PLACE_HOLDER = "[S]";
  public static final String LOC_SPAN_PLACE_HOLDER = "[L]";
  public static final float LOC_SPAN_RESIZE_FACTOR = 0.9F;
  public static final float OFFSET_IMAGE_SPAN = -0.1F;
  public static final int SPAN_ALIGN_MODE = 0;
  private static final int jdField_a_of_type_Int = 0;
  private static RichStatus jdField_a_of_type_ComTencentMobileqqRichstatusRichStatus;
  private static final int b = 1;
  private static final int c = 2;
  private static final int d = 3;
  private static final int e = 4;
  private static final int f = 128;
  private static final int g = 129;
  private static final int h = 130;
  private static final int i = 144;
  private static final int j = 145;
  private static final int k = 146;
  private static final int l = 147;
  private static final int m = 2;
  private static final int n = 8;
  private static final int o = 8;
  private static final int p = 10;
  private static final int q = 10;
  private static final int r = 12;
  private static final int s = 12;
  public static final ColorStateList sActionColor;
  private static final long serialVersionUID = 1L;
  private static final int t = 256;
  private static final int u = 2;
  public int actId;
  public int actionId = 0;
  public String actionText;
  private String cachedStatusContent;
  private String cachedStatusHeader;
  public int dataId = 0;
  public String dataText;
  public boolean enableSummaryCached;
  public String feedsId;
  public boolean isFirstReadUins = true;
  public byte[] key;
  public int latitude;
  public int locationPosition;
  public String locationText;
  public int lontitude;
  public List mUins;
  public ArrayList plainText;
  public HashMap sigZanInfo;
  public long time;
  public int tplId;
  public int tplType;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    int[] arrayOfInt = new int[0];
    sActionColor = new ColorStateList(new int[][] { { 16842919 }, arrayOfInt }, new int[] { -2039584, -8947849 });
  }
  
  public RichStatus(String paramString)
  {
    if (paramString != null)
    {
      this.plainText = new ArrayList();
      this.plainText.add(paramString);
    }
  }
  
  private static int a(String paramString)
  {
    return paramString.getBytes().length;
  }
  
  private void a(String paramString)
  {
    if (this.plainText == null) {
      this.plainText = new ArrayList();
    }
    this.plainText.add(paramString);
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      paramStringBuilder.append(paramString);
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, int paramInt, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.getBytes();
      paramByteBuffer.put((byte)paramInt).put((byte)paramString.length).put(paramString, 0, paramString.length);
    }
  }
  
  public static RichStatus getEmptyStatus()
  {
    if (a == null) {
      a = new RichStatus(null);
    }
    return a;
  }
  
  public static RichStatus parseStatus(byte[] paramArrayOfByte)
  {
    RichStatus localRichStatus = new RichStatus(null);
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 2)) {
      return localRichStatus;
    }
    ByteBuffer localByteBuffer = ByteBuffer.wrap(paramArrayOfByte);
    Object localObject1 = null;
    int i1 = 0;
    label80:
    int i3;
    int i2;
    for (;;)
    {
      if (localByteBuffer.hasRemaining())
      {
        if (localByteBuffer.remaining() >= 2) {
          break label80;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
        }
      }
      for (;;)
      {
        if (localObject1 != null) {
          localRichStatus.a((String)localObject1);
        }
        return localRichStatus;
        i3 = localByteBuffer.get();
        int i4 = localByteBuffer.get();
        i2 = i3;
        if (i3 < 0) {
          i2 = i3 + 256;
        }
        i3 = i4;
        if (i4 < 0) {
          i3 = i4 + 256;
        }
        if (localByteBuffer.remaining() >= i3) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
        }
      }
      i1 += 2;
      if ((i2 <= 0) || (i2 >= 128)) {
        break;
      }
      String str = new String(paramArrayOfByte, i1, i3);
      i1 = i3 + i1;
      localByteBuffer.position(i1);
      switch (i2)
      {
      case 3: 
      default: 
        if (localObject1 == null) {
          localObject1 = str;
        }
        break;
      case 1: 
        localRichStatus.actionText = str;
        break;
      case 2: 
        localRichStatus.dataText = str;
        break;
      case 4: 
        Object localObject2 = localObject1;
        if (localObject1 != null)
        {
          localRichStatus.a((String)localObject1);
          localObject2 = null;
        }
        if (localRichStatus.plainText != null) {}
        for (localRichStatus.locationPosition = localRichStatus.plainText.size();; localRichStatus.locationPosition = 0)
        {
          localRichStatus.locationText = str;
          localObject1 = localObject2;
          break;
        }
        localObject1 = (String)localObject1 + str;
      }
    }
    switch (i2)
    {
    }
    for (;;)
    {
      i1 += i3;
      localByteBuffer.position(i1);
      break;
      if (localByteBuffer.remaining() < 8)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
        }
      }
      else
      {
        localRichStatus.actionId = localByteBuffer.getInt();
        localRichStatus.dataId = localByteBuffer.getInt();
        continue;
        if (localByteBuffer.remaining() < 8)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte));
          }
        }
        else
        {
          localRichStatus.lontitude = localByteBuffer.getInt();
          localRichStatus.latitude = localByteBuffer.getInt();
          continue;
          localRichStatus.feedsId = new String(paramArrayOfByte, i1, i3);
          if (QLog.isColorLevel())
          {
            QLog.d("Q.richstatus.status", 2, HexUtil.a(paramArrayOfByte) + ",sign feeds id=" + localRichStatus.feedsId);
            continue;
            localRichStatus.tplId = localByteBuffer.getInt();
            continue;
            localRichStatus.tplType = localByteBuffer.getInt();
            continue;
            localRichStatus.actId = localByteBuffer.getInt();
          }
        }
      }
    }
  }
  
  protected Object clone()
  {
    Object localObject = null;
    try
    {
      RichStatus localRichStatus = (RichStatus)super.clone();
      localObject = localRichStatus;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      for (;;)
      {
        localCloneNotSupportedException.printStackTrace();
      }
    }
    if (this.plainText != null) {
      ((RichStatus)localObject).plainText = ((ArrayList)this.plainText.clone());
    }
    return localObject;
  }
  
  public int countLength()
  {
    return (countUtfLength() - 12 + 2) / 3;
  }
  
  public int countUtfLength()
  {
    int i1 = 0;
    if (!TextUtils.isEmpty(this.actionText)) {
      i1 = 0 + (a(this.actionText) + 12);
    }
    int i2 = i1;
    if (!TextUtils.isEmpty(this.dataText)) {
      i2 = i1 + (a(this.dataText) + 2);
    }
    i1 = i2;
    if (!TextUtils.isEmpty(this.locationText)) {
      i1 = i2 + (a(this.locationText) + 12);
    }
    if (this.plainText != null)
    {
      Iterator localIterator = this.plainText.iterator();
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label137;
      }
      String str = (String)localIterator.next();
      if (TextUtils.isEmpty(str)) {
        break label143;
      }
      i1 = a(str) + 2 + i1;
    }
    label137:
    label143:
    for (;;)
    {
      break;
      i2 = i1;
      return i2 + 12;
    }
  }
  
  public byte[] encode()
  {
    int i2 = 0;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(countUtfLength());
    a(localByteBuffer, 1, this.actionText);
    a(localByteBuffer, 2, this.dataText);
    int i1 = 0;
    while (i1 < this.locationPosition)
    {
      a(localByteBuffer, 3, (String)this.plainText.get(i1));
      i1 += 1;
    }
    a(localByteBuffer, 4, this.locationText);
    i1 = i2;
    if (this.plainText != null) {
      i1 = this.plainText.size();
    }
    i2 = this.locationPosition;
    while (i2 < i1)
    {
      a(localByteBuffer, 3, (String)this.plainText.get(i2));
      i2 += 1;
    }
    if (!TextUtils.isEmpty(this.actionText)) {
      localByteBuffer.put((byte)-127).put((byte)8).putInt(this.actionId).putInt(this.dataId);
    }
    if (!TextUtils.isEmpty(this.locationText)) {
      localByteBuffer.put((byte)-126).put((byte)8).putInt(this.lontitude).putInt(this.latitude);
    }
    localByteBuffer.put((byte)-111).put((byte)4).putInt(this.tplId);
    localByteBuffer.put((byte)-110).put((byte)4).putInt(this.tplType);
    return localByteBuffer.array();
  }
  
  public String getActionAndData()
  {
    Object localObject;
    if ((this.enableSummaryCached) && (this.cachedStatusHeader != null))
    {
      localObject = this.cachedStatusHeader;
      return (String)localObject;
    }
    String str;
    if (TextUtils.isEmpty(this.actionText)) {
      str = "";
    }
    for (;;)
    {
      localObject = str;
      if (!this.enableSummaryCached) {
        break;
      }
      this.cachedStatusHeader = str;
      return str;
      if (TextUtils.isEmpty(this.dataText)) {
        str = this.actionText;
      } else {
        str = this.actionText + this.dataText;
      }
    }
  }
  
  public CharSequence getLocSS(TextView paramTextView)
  {
    return getLocSS(paramTextView, "");
  }
  
  public CharSequence getLocSS(TextView paramTextView, CharSequence paramCharSequence)
  {
    if (TextUtils.isEmpty(this.locationText)) {
      return paramCharSequence;
    }
    Object localObject2 = new StringBuilder().append("[L] ").append(this.locationText);
    if (paramCharSequence != null) {}
    for (Object localObject1 = " " + paramCharSequence;; localObject1 = "")
    {
      localObject1 = new SpannableString((String)localObject1);
      localObject2 = paramTextView.getResources();
      try
      {
        Bitmap localBitmap = BitmapFactory.decodeResource((Resources)localObject2, 2130842872);
        int i1 = (int)(paramTextView.getTextSize() * 0.9F + 0.5F);
        int i2 = localBitmap.getWidth() * i1 / localBitmap.getHeight();
        paramTextView = new StatableBitmapDrawable((Resources)localObject2, localBitmap, false, true);
        paramTextView.setBounds(0, 0, i2, i1);
        ((SpannableString)localObject1).setSpan(new OffsetableImageSpan(paramTextView, 0).a(-0.1F), 0, "[L]".length(), 33);
        return (CharSequence)localObject1;
      }
      catch (OutOfMemoryError paramTextView) {}
    }
    return paramCharSequence;
  }
  
  public String getPlainText()
  {
    int i2 = 0;
    if ((this.enableSummaryCached) && (this.cachedStatusContent != null)) {
      return this.cachedStatusContent;
    }
    StringBuilder localStringBuilder = new StringBuilder(100);
    int i1 = 0;
    while (i1 < this.locationPosition)
    {
      a(localStringBuilder, (String)this.plainText.get(i1));
      i1 += 1;
    }
    i1 = i2;
    if (this.plainText != null) {
      i1 = this.plainText.size();
    }
    i2 = this.locationPosition;
    while (i2 < i1)
    {
      a(localStringBuilder, (String)this.plainText.get(i2));
      i2 += 1;
    }
    if (this.enableSummaryCached) {
      this.cachedStatusContent = localStringBuilder.toString();
    }
    return localStringBuilder.toString();
  }
  
  public boolean isEmpty()
  {
    int i2;
    if (this.plainText != null)
    {
      Iterator localIterator = this.plainText.iterator();
      int i1 = 1;
      i2 = i1;
      if (!localIterator.hasNext()) {
        break label50;
      }
      if (TextUtils.isEmpty((String)localIterator.next())) {
        break label82;
      }
      i1 = 0;
    }
    label50:
    label82:
    for (;;)
    {
      break;
      i2 = 1;
      return (this.actionId == 0) && (this.dataId == 0) && (i2 != 0) && (TextUtils.isEmpty(this.locationText));
    }
  }
  
  public SpannableString toSpannableString(String paramString)
  {
    return toSpannableString(paramString, -8947849);
  }
  
  public SpannableString toSpannableString(String paramString, int paramInt)
  {
    return toSpannableString(paramString, paramInt, -2039584);
  }
  
  public SpannableString toSpannableString(String paramString, int paramInt1, int paramInt2)
  {
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    paramString = new StringBuilder(str);
    a(paramString, this.actionText);
    a(paramString, this.dataText);
    int i3 = paramString.length();
    if (i3 > str.length()) {
      paramString.append(' ');
    }
    int i1 = 0;
    while (i1 < this.locationPosition)
    {
      a(paramString, (String)this.plainText.get(i1));
      i1 += 1;
    }
    if (this.plainText != null) {}
    for (i1 = this.plainText.size();; i1 = 0)
    {
      int i2 = this.locationPosition;
      while (i2 < i1)
      {
        a(paramString, (String)this.plainText.get(i2));
        i2 += 1;
      }
    }
    paramString = new SpannableString(paramString.toString());
    if (i3 > str.length()) {
      paramString.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(paramInt1, paramInt2), 0, i3, 33);
    }
    return paramString;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\richstatus\RichStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */