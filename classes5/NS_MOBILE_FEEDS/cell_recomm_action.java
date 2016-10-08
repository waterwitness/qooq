package NS_MOBILE_FEEDS;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public final class cell_recomm_action
  extends JceStruct
{
  static s_bottom_bar cache_bottom_bar = new s_bottom_bar();
  static s_rank cache_s_app_rank;
  static ArrayList cache_userlist;
  public int actiontype;
  public int allcount;
  public s_bottom_bar bottom_bar;
  public int btn_type;
  public int button_actiontype;
  public int button_style;
  public String button_text = "";
  public String button_url = "";
  public int detail_actiontype;
  public String detail_text = "";
  public String detail_url = "";
  public int is_hide_action_area;
  public int is_report;
  public String remark = "";
  public String report_url = "";
  public s_rank s_app_rank;
  public String tips_icon = "";
  public ArrayList userlist;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    cache_s_app_rank = new s_rank();
    cache_userlist = new ArrayList();
    s_user locals_user = new s_user();
    cache_userlist.add(locals_user);
  }
  
  public cell_recomm_action() {}
  
  public cell_recomm_action(s_rank params_rank, String paramString1, ArrayList paramArrayList, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, String paramString3, int paramInt6, String paramString4, int paramInt7, String paramString5, int paramInt8, String paramString6, s_bottom_bar params_bottom_bar, String paramString7)
  {
    this.s_app_rank = params_rank;
    this.remark = paramString1;
    this.userlist = paramArrayList;
    this.actiontype = paramInt1;
    this.btn_type = paramInt2;
    this.is_hide_action_area = paramInt3;
    this.is_report = paramInt4;
    this.report_url = paramString2;
    this.allcount = paramInt5;
    this.button_text = paramString3;
    this.button_actiontype = paramInt6;
    this.button_url = paramString4;
    this.button_style = paramInt7;
    this.detail_text = paramString5;
    this.detail_actiontype = paramInt8;
    this.detail_url = paramString6;
    this.bottom_bar = params_bottom_bar;
    this.tips_icon = paramString7;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.s_app_rank = ((s_rank)paramJceInputStream.read(cache_s_app_rank, 0, false));
    this.remark = paramJceInputStream.readString(1, false);
    this.userlist = ((ArrayList)paramJceInputStream.read(cache_userlist, 2, false));
    this.actiontype = paramJceInputStream.read(this.actiontype, 3, false);
    this.btn_type = paramJceInputStream.read(this.btn_type, 4, false);
    this.is_hide_action_area = paramJceInputStream.read(this.is_hide_action_area, 5, false);
    this.is_report = paramJceInputStream.read(this.is_report, 6, false);
    this.report_url = paramJceInputStream.readString(7, false);
    this.allcount = paramJceInputStream.read(this.allcount, 8, false);
    this.button_text = paramJceInputStream.readString(9, false);
    this.button_actiontype = paramJceInputStream.read(this.button_actiontype, 10, false);
    this.button_url = paramJceInputStream.readString(11, false);
    this.button_style = paramJceInputStream.read(this.button_style, 12, false);
    this.detail_text = paramJceInputStream.readString(13, false);
    this.detail_actiontype = paramJceInputStream.read(this.detail_actiontype, 14, false);
    this.detail_url = paramJceInputStream.readString(15, false);
    this.bottom_bar = ((s_bottom_bar)paramJceInputStream.read(cache_bottom_bar, 16, false));
    this.tips_icon = paramJceInputStream.readString(17, false);
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.s_app_rank != null) {
      paramJceOutputStream.write(this.s_app_rank, 0);
    }
    if (this.remark != null) {
      paramJceOutputStream.write(this.remark, 1);
    }
    if (this.userlist != null) {
      paramJceOutputStream.write(this.userlist, 2);
    }
    paramJceOutputStream.write(this.actiontype, 3);
    paramJceOutputStream.write(this.btn_type, 4);
    paramJceOutputStream.write(this.is_hide_action_area, 5);
    paramJceOutputStream.write(this.is_report, 6);
    if (this.report_url != null) {
      paramJceOutputStream.write(this.report_url, 7);
    }
    paramJceOutputStream.write(this.allcount, 8);
    if (this.button_text != null) {
      paramJceOutputStream.write(this.button_text, 9);
    }
    paramJceOutputStream.write(this.button_actiontype, 10);
    if (this.button_url != null) {
      paramJceOutputStream.write(this.button_url, 11);
    }
    paramJceOutputStream.write(this.button_style, 12);
    if (this.detail_text != null) {
      paramJceOutputStream.write(this.detail_text, 13);
    }
    paramJceOutputStream.write(this.detail_actiontype, 14);
    if (this.detail_url != null) {
      paramJceOutputStream.write(this.detail_url, 15);
    }
    if (this.bottom_bar != null) {
      paramJceOutputStream.write(this.bottom_bar, 16);
    }
    if (this.tips_icon != null) {
      paramJceOutputStream.write(this.tips_icon, 17);
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\NS_MOBILE_FEEDS\cell_recomm_action.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */