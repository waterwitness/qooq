package NS_MOBILE_FEEDS;

import NS_MOBILE_COMM.sparkle_word;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class cell_summary
  extends JceStruct
{
  static Map cache_mapExt;
  static sparkle_word cache_sparkleword;
  static ArrayList cache_summarypic;
  public int actiontype;
  public int hasmore;
  public Map mapExt;
  public String more_info = "";
  public sparkle_word sparkleword;
  public String summary = "";
  public ArrayList summarypic;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_summarypic = new ArrayList();
    s_picdata locals_picdata = new s_picdata();
    cache_summarypic.add(locals_picdata);
    cache_sparkleword = new sparkle_word();
    cache_mapExt = new HashMap();
    cache_mapExt.put("", "");
  }
  
  public cell_summary() {}
  
  public cell_summary(String paramString1, int paramInt1, int paramInt2, ArrayList paramArrayList, String paramString2, sparkle_word paramsparkle_word, Map paramMap)
  {
    this.summary = paramString1;
    this.hasmore = paramInt1;
    this.actiontype = paramInt2;
    this.summarypic = paramArrayList;
    this.more_info = paramString2;
    this.sparkleword = paramsparkle_word;
    this.mapExt = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.summary = paramJceInputStream.readString(0, false);
    this.hasmore = paramJceInputStream.read(this.hasmore, 1, false);
    this.actiontype = paramJceInputStream.read(this.actiontype, 2, false);
    this.summarypic = ((ArrayList)paramJceInputStream.read(cache_summarypic, 3, false));
    this.more_info = paramJceInputStream.readString(4, false);
    this.sparkleword = ((sparkle_word)paramJceInputStream.read(cache_sparkleword, 5, false));
    this.mapExt = ((Map)paramJceInputStream.read(cache_mapExt, 6, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.summary != null) {
      paramJceOutputStream.write(this.summary, 0);
    }
    paramJceOutputStream.write(this.hasmore, 1);
    paramJceOutputStream.write(this.actiontype, 2);
    if (this.summarypic != null) {
      paramJceOutputStream.write(this.summarypic, 3);
    }
    if (this.more_info != null) {
      paramJceOutputStream.write(this.more_info, 4);
    }
    if (this.sparkleword != null) {
      paramJceOutputStream.write(this.sparkleword, 5);
    }
    if (this.mapExt != null) {
      paramJceOutputStream.write(this.mapExt, 6);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_summary.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */