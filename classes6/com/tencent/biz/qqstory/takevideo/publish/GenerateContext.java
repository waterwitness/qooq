package com.tencent.biz.qqstory.takevideo.publish;

import android.view.View;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.lang.ref.WeakReference;

public class GenerateContext
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private GenerateBackgroundMusicArgs jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateBackgroundMusicArgs;
  private GenerateDoodleArgs jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateDoodleArgs;
  private GenerateThumbArgs jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs;
  private GenerateThumbResult jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbResult;
  private GenerateVideoArgs jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateVideoArgs;
  private GenerateVideoResult jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateVideoResult;
  private PublishParam jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private String b;
  private String c;
  private String d;
  
  public GenerateContext()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public View a()
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference != null) {
      return (View)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    }
    return null;
  }
  
  public GenerateBackgroundMusicArgs a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateBackgroundMusicArgs;
  }
  
  public GenerateDoodleArgs a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateDoodleArgs;
  }
  
  public GenerateThumbArgs a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs;
  }
  
  public GenerateThumbResult a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbResult;
  }
  
  public GenerateVideoArgs a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateVideoArgs;
  }
  
  public GenerateVideoResult a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateVideoResult;
  }
  
  public PublishParam a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(View paramView)
  {
    if (paramView == null)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = null;
      return;
    }
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramView);
  }
  
  public void a(GenerateBackgroundMusicArgs paramGenerateBackgroundMusicArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateBackgroundMusicArgs = paramGenerateBackgroundMusicArgs;
  }
  
  public void a(GenerateDoodleArgs paramGenerateDoodleArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateDoodleArgs = paramGenerateDoodleArgs;
  }
  
  public void a(GenerateThumbArgs paramGenerateThumbArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs = paramGenerateThumbArgs;
  }
  
  public void a(GenerateThumbResult paramGenerateThumbResult)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbResult = paramGenerateThumbResult;
  }
  
  public void a(GenerateVideoArgs paramGenerateVideoArgs)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateVideoArgs = paramGenerateVideoArgs;
  }
  
  public void a(GenerateVideoResult paramGenerateVideoResult)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateVideoResult = paramGenerateVideoResult;
  }
  
  public void a(PublishParam paramPublishParam)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishPublishParam = paramPublishParam;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public byte[] a()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public String b()
  {
    return this.b;
  }
  
  public void b(String paramString)
  {
    this.b = paramString;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public void c(String paramString)
  {
    this.c = paramString;
  }
  
  public String d()
  {
    return this.d;
  }
  
  public void d(String paramString)
  {
    this.d = paramString;
  }
  
  public String toString()
  {
    return "GenerateContext{generateDoodleArgs=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateDoodleArgs + ", generateDoodleResult=" + this.jdField_a_of_type_Boolean + ", videoDuration=" + this.jdField_a_of_type_Long + ", generateVideoArgs=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateVideoArgs + ", generateVideoResult=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateVideoResult + ", generateThumbArgs=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbArgs + ", generateThumbResult=" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateThumbResult + ", generateBackgroundArgs='" + this.jdField_a_of_type_ComTencentBizQqstoryTakevideoPublishGenerateBackgroundMusicArgs + ", videoLabel='" + this.b + '\'' + ", videoAddress='" + this.c + '\'' + '}';
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\takevideo\publish\GenerateContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */