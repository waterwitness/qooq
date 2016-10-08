package com.tencent.mobileqq.activity.qqcard;

import QCARD.CouponMobileItem;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import org.json.JSONException;
import org.json.JSONObject;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="cardId,code,field")
public class QQCardItem
  extends Entity
{
  public static final String Table_Name = "t_qqcard_item";
  public String bgUrl;
  public String brand;
  public String cardId;
  public String code;
  public String distance;
  public long expireTime;
  public int field;
  public int folderId;
  public int fromColor;
  public String iconUrl;
  @notColumn
  public boolean isNew;
  public int isValid;
  @notColumn
  public int itemType;
  public String jumpUrl;
  public String nextCardId;
  public int status;
  public String subTitle;
  public String title;
  public int validTipsColor;
  public String validTipsFormat;
  
  public QQCardItem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.validTipsColor = -1;
    this.fromColor = -1;
  }
  
  public QQCardItem(CouponMobileItem paramCouponMobileItem, int paramInt1, int paramInt2)
  {
    this.validTipsColor = -1;
    this.fromColor = -1;
    this.folderId = paramInt2;
    this.itemType = paramInt1;
    setValue(paramCouponMobileItem);
  }
  
  public void copy(QQCardItem paramQQCardItem)
  {
    this.status = paramQQCardItem.status;
    this.title = paramQQCardItem.title;
    this.subTitle = paramQQCardItem.subTitle;
    this.brand = paramQQCardItem.brand;
    this.validTipsFormat = paramQQCardItem.validTipsFormat;
    this.expireTime = paramQQCardItem.expireTime;
    this.iconUrl = paramQQCardItem.iconUrl;
    this.jumpUrl = paramQQCardItem.jumpUrl;
    this.bgUrl = paramQQCardItem.bgUrl;
    this.validTipsColor = paramQQCardItem.validTipsColor;
    this.fromColor = paramQQCardItem.fromColor;
    this.distance = paramQQCardItem.distance;
    this.isValid = paramQQCardItem.isValid;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof QQCardItem))
    {
      paramObject = (QQCardItem)paramObject;
      if ((((QQCardItem)paramObject).cardId.equals(this.cardId)) && (((QQCardItem)paramObject).code.equals(this.code)) && (((QQCardItem)paramObject).field == this.field)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean equalsId(String paramString)
  {
    return (this.field + "_" + this.cardId + "_" + this.code).equals(paramString);
  }
  
  public String getTableName()
  {
    return "t_qqcard_item";
  }
  
  public String getUID()
  {
    return this.field + "_" + this.cardId + "_" + this.code;
  }
  
  public void setValue(CouponMobileItem paramCouponMobileItem)
  {
    this.cardId = paramCouponMobileItem.card_id;
    this.code = paramCouponMobileItem.code;
    this.field = paramCouponMobileItem.field;
    this.status = paramCouponMobileItem.status;
    this.title = paramCouponMobileItem.title;
    this.subTitle = paramCouponMobileItem.sub_title;
    this.brand = paramCouponMobileItem.from;
    this.validTipsFormat = paramCouponMobileItem.valid_tips_format;
    this.expireTime = paramCouponMobileItem.expire_time;
    this.iconUrl = paramCouponMobileItem.icon_url;
    this.jumpUrl = paramCouponMobileItem.jump_url;
    try
    {
      JSONObject localJSONObject = new JSONObject(paramCouponMobileItem.style_json_str);
      if (localJSONObject.has("background_url")) {
        this.bgUrl = localJSONObject.getString("background_url");
      }
      if (localJSONObject.has("valid_tips_color")) {
        this.validTipsColor = localJSONObject.getInt("valid_tips_color");
      }
      if (localJSONObject.has("from_color")) {
        this.fromColor = localJSONObject.getInt("from_color");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
    this.distance = paramCouponMobileItem.distance;
    this.isValid = paramCouponMobileItem.is_valid;
    this.nextCardId = paramCouponMobileItem.next_cardid;
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\activity\qqcard\QQCardItem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */