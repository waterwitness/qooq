package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_red_bonus
  extends JceStruct
{
  static ArrayList cache_payMans;
  public String actionUrl = "";
  public int isPayed;
  public ArrayList payMans;
  public long payMenNum;
  public long payMoney;
  public long payNum;
  public long payTotalAccount;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_payMans = new ArrayList();
    s_redbonus_man locals_redbonus_man = new s_redbonus_man();
    cache_payMans.add(locals_redbonus_man);
  }
  
  public cell_red_bonus() {}
  
  public cell_red_bonus(long paramLong1, long paramLong2, int paramInt, long paramLong3, ArrayList paramArrayList, String paramString, long paramLong4)
  {
    this.payNum = paramLong1;
    this.payTotalAccount = paramLong2;
    this.isPayed = paramInt;
    this.payMoney = paramLong3;
    this.payMans = paramArrayList;
    this.actionUrl = paramString;
    this.payMenNum = paramLong4;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.payNum = paramJceInputStream.read(this.payNum, 0, false);
    this.payTotalAccount = paramJceInputStream.read(this.payTotalAccount, 1, false);
    this.isPayed = paramJceInputStream.read(this.isPayed, 2, false);
    this.payMoney = paramJceInputStream.read(this.payMoney, 3, false);
    this.payMans = ((ArrayList)paramJceInputStream.read(cache_payMans, 4, false));
    this.actionUrl = paramJceInputStream.readString(5, false);
    this.payMenNum = paramJceInputStream.read(this.payMenNum, 6, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.payNum, 0);
    paramJceOutputStream.write(this.payTotalAccount, 1);
    paramJceOutputStream.write(this.isPayed, 2);
    paramJceOutputStream.write(this.payMoney, 3);
    if (this.payMans != null) {
      paramJceOutputStream.write(this.payMans, 4);
    }
    if (this.actionUrl != null) {
      paramJceOutputStream.write(this.actionUrl, 5);
    }
    paramJceOutputStream.write(this.payMenNum, 6);
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_red_bonus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */