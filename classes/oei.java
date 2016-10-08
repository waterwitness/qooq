import com.tencent.mobileqq.activity.aio.tips.ComicTipsBar;
import com.tencent.mobileqq.activity.aio.tips.TipsManager;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;

class oei
  implements Runnable
{
  oei(oeh paramoeh)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    if (ComicTipsBar.a(this.a.a) != null) {
      ComicTipsBar.a(this.a.a).b();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\oei.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */