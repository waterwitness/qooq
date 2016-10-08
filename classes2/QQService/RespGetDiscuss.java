package QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetDiscuss
  extends JceStruct
  implements Cloneable
{
  static ArrayList cache_DiscussList;
  static ArrayList cache_FavoriteDiscussList;
  public ArrayList DiscussList;
  public ArrayList FavoriteDiscussList;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    if (!RespGetDiscuss.class.desiredAssertionStatus()) {}
    for (bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public RespGetDiscuss() {}
  
  public RespGetDiscuss(ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    this.DiscussList = paramArrayList1;
    this.FavoriteDiscussList = paramArrayList2;
  }
  
  public String className()
  {
    return "QQService.RespGetDiscuss";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.DiscussList, "DiscussList");
    paramStringBuilder.display(this.FavoriteDiscussList, "FavoriteDiscussList");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.DiscussList, true);
    paramStringBuilder.displaySimple(this.FavoriteDiscussList, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RespGetDiscuss)paramObject;
    } while ((!JceUtil.equals(this.DiscussList, ((RespGetDiscuss)paramObject).DiscussList)) || (!JceUtil.equals(this.FavoriteDiscussList, ((RespGetDiscuss)paramObject).FavoriteDiscussList)));
    return true;
  }
  
  public String fullClassName()
  {
    return "QQService.RespGetDiscuss";
  }
  
  public ArrayList getDiscussList()
  {
    return this.DiscussList;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    DiscussInfo localDiscussInfo;
    if (cache_DiscussList == null)
    {
      cache_DiscussList = new ArrayList();
      localDiscussInfo = new DiscussInfo();
      cache_DiscussList.add(localDiscussInfo);
    }
    this.DiscussList = ((ArrayList)paramJceInputStream.read(cache_DiscussList, 0, true));
    if (cache_FavoriteDiscussList == null)
    {
      cache_FavoriteDiscussList = new ArrayList();
      localDiscussInfo = new DiscussInfo();
      cache_FavoriteDiscussList.add(localDiscussInfo);
    }
    this.FavoriteDiscussList = ((ArrayList)paramJceInputStream.read(cache_FavoriteDiscussList, 1, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.DiscussList, 0);
    if (this.FavoriteDiscussList != null) {
      paramJceOutputStream.write(this.FavoriteDiscussList, 1);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\QQService\RespGetDiscuss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */