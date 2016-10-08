package com.tencent.biz.qqstory.base.videoupload.meta;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.EncodeVideoTask;
import com.tencent.biz.qqstory.takevideo.publish.VideoProcessListener;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import iid;

public class GenerateVideoSegment
  extends UploadObject
  implements VideoProcessListener
{
  protected static final String a = "Q.qqstory.publish:GenerateVideoSegment";
  protected int a;
  public long a;
  private boolean a;
  public byte[] a;
  public int b;
  private long b;
  protected String b;
  public String c;
  public String d;
  
  public GenerateVideoSegment(String paramString1, byte[] paramArrayOfByte, int paramInt1, String paramString2, int paramInt2, boolean paramBoolean)
  {
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_Int = paramInt1;
    this.d = paramString2;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  protected void a()
  {
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    new EncodeVideoTask(new Handler(Looper.getMainLooper()), this, this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean).execute(new Void[] { (Void)null });
  }
  
  public void a(boolean paramBoolean, String paramString, byte[] paramArrayOfByte, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, String paramString1, byte[] paramArrayOfByte, String paramString2, long paramLong)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1)) && (com.tencent.biz.qqstory.utils.FileUtils.b(paramString1)))
    {
      SLog.a("Q.qqstory.publish:GenerateVideoSegment", "encode video take time:%d, success：%s", Long.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), paramString1);
      this.c = paramString1;
      this.jdField_a_of_type_Long = paramLong;
      if (TextUtils.isEmpty(this.d))
      {
        super.b();
        super.notifyResult(new ErrorMessage());
        com.tencent.mobileqq.utils.FileUtils.a(this.jdField_b_of_type_JavaLangString);
        return;
      }
      Bosses.get().postJob(new iid(this, paramString1));
      return;
    }
    SLog.d("Q.qqstory.publish:GenerateVideoSegment", "encode video failed with result:" + paramBoolean);
    super.notifyError(new ErrorMessage(941000, "EncodeVideoTask error:" + paramBoolean));
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\base\videoupload\meta\GenerateVideoSegment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */