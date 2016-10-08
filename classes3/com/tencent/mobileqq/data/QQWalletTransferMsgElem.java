package com.tencent.mobileqq.data;

import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.msg.im_msg_body.QQWalletAioElem;

public class QQWalletTransferMsgElem
{
  public String actionsPriority;
  public String aioImageLeft;
  public String aioImageRight;
  public int background;
  public String blackStripe;
  public String cftImage;
  public String content;
  public int contentBgColor;
  public int contentColor;
  public int icon;
  public String iconUrl;
  public String jumpUrl;
  public String linkUrl;
  public String nativeAndroid;
  public String notice;
  public String subTitle;
  public int subtitleColor;
  public String title;
  public int titleColor;
  
  public QQWalletTransferMsgElem()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public QQWalletTransferMsgElem(im_msg_body.QQWalletAioElem paramQQWalletAioElem)
  {
    if (paramQQWalletAioElem == null) {
      return;
    }
    this.background = paramQQWalletAioElem.uint32_background.get();
    this.icon = paramQQWalletAioElem.uint32_icon.get();
    this.title = paramQQWalletAioElem.bytes_title.get().toStringUtf8();
    this.subTitle = paramQQWalletAioElem.bytes_subtitle.get().toStringUtf8();
    this.content = paramQQWalletAioElem.bytes_content.get().toStringUtf8();
    this.linkUrl = paramQQWalletAioElem.bytes_linkurl.get().toStringUtf8();
    this.blackStripe = paramQQWalletAioElem.bytes_blackstripe.get().toStringUtf8();
    this.notice = paramQQWalletAioElem.bytes_notice.get().toStringUtf8();
    if (this.linkUrl == null) {
      this.linkUrl = "";
    }
    if (this.blackStripe == null) {
      this.blackStripe = "";
    }
    if (this.notice == null) {
      this.notice = "";
    }
    this.background |= 0xFF000000;
    if (paramQQWalletAioElem.uint32_title_color.has())
    {
      this.titleColor = paramQQWalletAioElem.uint32_title_color.get();
      this.titleColor |= 0xFF000000;
      if (!paramQQWalletAioElem.uint32_subtitle_color.has()) {
        break label470;
      }
      this.subtitleColor = paramQQWalletAioElem.uint32_subtitle_color.get();
      this.subtitleColor |= 0xFF000000;
      label229:
      if (!paramQQWalletAioElem.bytes_actions_priority.has()) {
        break label478;
      }
      this.actionsPriority = paramQQWalletAioElem.bytes_actions_priority.get().toStringUtf8();
      label253:
      if (!paramQQWalletAioElem.bytes_jump_url.has()) {
        break label487;
      }
      this.jumpUrl = paramQQWalletAioElem.bytes_jump_url.get().toStringUtf8();
      label277:
      if (!paramQQWalletAioElem.bytes_native_android.has()) {
        break label496;
      }
      this.nativeAndroid = paramQQWalletAioElem.bytes_native_android.get().toStringUtf8();
      label301:
      if (!paramQQWalletAioElem.bytes_iconurl.has()) {
        break label505;
      }
      this.iconUrl = paramQQWalletAioElem.bytes_iconurl.get().toStringUtf8();
      label325:
      if (!paramQQWalletAioElem.uint32_content_color.has()) {
        break label514;
      }
      this.contentColor = paramQQWalletAioElem.uint32_content_color.get();
      this.contentColor |= 0xFF000000;
      label357:
      if (!paramQQWalletAioElem.uint32_content_bgcolor.has()) {
        break label522;
      }
      this.contentBgColor = paramQQWalletAioElem.uint32_content_bgcolor.get();
      this.contentBgColor |= 0xFF000000;
      label389:
      if (!paramQQWalletAioElem.bytes_aio_image_left.has()) {
        break label530;
      }
      this.aioImageLeft = paramQQWalletAioElem.bytes_aio_image_left.get().toStringUtf8();
      label413:
      if (!paramQQWalletAioElem.bytes_aio_image_right.has()) {
        break label539;
      }
    }
    label470:
    label478:
    label487:
    label496:
    label505:
    label514:
    label522:
    label530:
    label539:
    for (this.aioImageRight = paramQQWalletAioElem.bytes_aio_image_right.get().toStringUtf8();; this.aioImageRight = "")
    {
      if (!paramQQWalletAioElem.bytes_cft_image.has()) {
        break label548;
      }
      this.cftImage = paramQQWalletAioElem.bytes_cft_image.get().toStringUtf8();
      return;
      this.titleColor = -1;
      break;
      this.subtitleColor = -1;
      break label229;
      this.actionsPriority = "";
      break label253;
      this.jumpUrl = "";
      break label277;
      this.nativeAndroid = "";
      break label301;
      this.iconUrl = "";
      break label325;
      this.contentColor = -1;
      break label357;
      this.contentBgColor = -1;
      break label389;
      this.aioImageLeft = "";
      break label413;
    }
    label548:
    this.cftImage = "";
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\mobileqq\data\QQWalletTransferMsgElem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */