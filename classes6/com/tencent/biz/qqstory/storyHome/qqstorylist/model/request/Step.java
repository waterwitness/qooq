package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

public abstract interface Step
{
  public static final String c = "Q.qqstory.home.qqstory_step";
  
  public abstract Step a();
  
  public abstract Object a();
  
  public abstract String a();
  
  public abstract void a();
  
  public abstract void a(Step.ErrorCallBack paramErrorCallBack);
  
  public abstract void a(Step.FinishCallBack paramFinishCallBack);
  
  public abstract void a(Step paramStep);
  
  public abstract void a(Object paramObject);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean a();
  
  public abstract void b();
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\com\tencent\biz\qqstory\storyHome\qqstorylist\model\request\Step.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */