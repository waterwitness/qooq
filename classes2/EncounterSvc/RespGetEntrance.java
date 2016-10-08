package EncounterSvc;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class RespGetEntrance
  extends JceStruct
{
  static ArrayList cache_entrance_list;
  static ArrayList cache_xml_list;
  public ArrayList entrance_list;
  public long interval;
  public ArrayList xml_list;
  
  public RespGetEntrance()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.interval = 300L;
  }
  
  public RespGetEntrance(ArrayList paramArrayList1, long paramLong, ArrayList paramArrayList2)
  {
    this.interval = 300L;
    this.entrance_list = paramArrayList1;
    this.interval = paramLong;
    this.xml_list = paramArrayList2;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_entrance_list == null)
    {
      cache_entrance_list = new ArrayList();
      EntranceContent localEntranceContent = new EntranceContent();
      cache_entrance_list.add(localEntranceContent);
    }
    this.entrance_list = ((ArrayList)paramJceInputStream.read(cache_entrance_list, 0, false));
    this.interval = paramJceInputStream.read(this.interval, 1, false);
    if (cache_xml_list == null)
    {
      cache_xml_list = new ArrayList();
      cache_xml_list.add("");
    }
    this.xml_list = ((ArrayList)paramJceInputStream.read(cache_xml_list, 2, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.entrance_list != null) {
      paramJceOutputStream.write(this.entrance_list, 0);
    }
    paramJceOutputStream.write(this.interval, 1);
    if (this.xml_list != null) {
      paramJceOutputStream.write(this.xml_list, 2);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\EncounterSvc\RespGetEntrance.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */