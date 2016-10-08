package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FlashPicHelper;
import com.tencent.mobileqq.app.HotChatHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForApollo;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForMixedMsg;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.fileviewer.FilePicQFavActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileOption;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.pic.PicBusiManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.PicStatisticsManager;
import com.tencent.mobileqq.pic.PreDownloadStrategyBeta;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoDownloadInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoReq;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemImage;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.BaseDownloadProcessor;
import com.tencent.mobileqq.transfile.C2CPicDownloadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import cooperation.qqfav.QfavBuilder;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AccountNotMatchException;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import nuj;
import nuk;
import num;
import nun;
import nuo;
import nup;
import nuq;

public class AIOImageProviderService
  extends IAIOImageProvider.Stub
{
  static final String jdField_a_of_type_JavaLangString = "AIOImageProviderService";
  static final HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private static final int z = 60;
  public int a;
  public long a;
  public AIOImageProviderService.AIOImageProviderListener a;
  public FMObserver a;
  WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  public final List a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public final List b;
  public volatile boolean b;
  public int c;
  public long c;
  public String c;
  public List c;
  public volatile boolean c;
  public int d;
  public long d;
  
  static
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public AIOImageProviderService(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_JavaUtilList = Collections.synchronizedList(new LinkedList());
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_b_of_type_Long = Long.MAX_VALUE;
    this.jdField_c_of_type_Long = Long.MAX_VALUE;
    this.jdField_b_of_type_Int = 3;
    this.jdField_d_of_type_Long = Long.MAX_VALUE;
    this.jdField_c_of_type_Int = 60;
    this.jdField_d_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_c_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
    if (paramChatMessage != null)
    {
      this.jdField_a_of_type_Boolean = paramChatMessage.isMultiMsg;
      this.jdField_a_of_type_Long = paramChatMessage.msgseq;
      this.jdField_a_of_type_JavaUtilList.add(paramChatMessage);
    }
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(ThreadManager.a(), null);
    if ((!this.jdField_a_of_type_Boolean) && (!MessageForApollo.class.isInstance(paramChatMessage)))
    {
      paramString1 = paramString1 + "_" + paramString2 + "_" + paramInt;
      paramString2 = (AIOImageProviderService)jdField_a_of_type_JavaUtilHashMap.get(paramString1);
      if (paramString2 != null) {
        paramString2.a();
      }
      jdField_a_of_type_JavaUtilHashMap.put(paramString1, this);
    }
  }
  
  public static AIOImageProviderService a(String paramString1, String paramString2, int paramInt, ChatMessage paramChatMessage, boolean paramBoolean)
  {
    String str = paramString1 + "_" + paramString2 + "_" + paramInt;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramBoolean) {
      if (paramChatMessage != null)
      {
        localObject1 = localObject2;
        if (paramChatMessage.isMultiMsg) {}
      }
      else
      {
        localObject1 = (AIOImageProviderService)jdField_a_of_type_JavaUtilHashMap.get(str);
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new AIOImageProviderService(paramString1, paramString2, paramInt, paramChatMessage);
    }
    return (AIOImageProviderService)localObject2;
  }
  
  private ChatMessage a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator.next();
          if (paramLong != localChatMessage.uniseq) {
            continue;
          }
          return localChatMessage;
        }
      }
      Object localObject2 = null;
    }
  }
  
  private List a(QQAppInterface paramQQAppInterface, List paramList)
  {
    long l = System.currentTimeMillis();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = 0;
    if (k < paramList.size())
    {
      Object localObject1 = (MessageRecord)paramList.get(k);
      int i = ((MessageRecord)localObject1).msgtype;
      if (((MessageRecord)localObject1).shmsgseq < this.jdField_c_of_type_Long) {
        this.jdField_c_of_type_Long = ((MessageRecord)localObject1).shmsgseq;
      }
      if (((MessageRecord)localObject1).versionCode < this.jdField_b_of_type_Int) {
        this.jdField_b_of_type_Int = ((MessageRecord)localObject1).versionCode;
      }
      if ((((MessageRecord)localObject1).getId() > 0L) && (((MessageRecord)localObject1).getId() < this.jdField_b_of_type_Long)) {
        this.jdField_b_of_type_Long = ((MessageRecord)localObject1).getId();
      }
      if (((MessageRecord)localObject1).time < this.jdField_d_of_type_Long) {
        this.jdField_d_of_type_Long = ((MessageRecord)localObject1).time;
      }
      if ((localObject1 instanceof MessageForPic))
      {
        localObject1 = (MessageForPic)localObject1;
        ((MessageForPic)localObject1).parse();
        if ((i == 62536) || (i == 35533)) {
          if (QLog.isColorLevel()) {
            QLog.i("AIOImageProviderService", 2, "LoadMediaTask msgType is " + i);
          }
        }
      }
      for (;;)
      {
        k += 1;
        break;
        if ((!HotChatHelper.a((MessageRecord)localObject1)) && (!FlashPicHelper.a((MessageRecord)localObject1)))
        {
          localArrayList1.add(AIOGalleryUtils.a((MessageForPic)localObject1));
          localArrayList2.add(localObject1);
          continue;
          Object localObject2;
          if ((localObject1 instanceof MessageForMixedMsg))
          {
            localObject1 = (MessageForMixedMsg)localObject1;
            ((MessageForMixedMsg)localObject1).parse();
            localObject1 = ((MessageForMixedMsg)localObject1).msgElemList.iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if ((localObject2 instanceof MessageForPic))
              {
                localArrayList1.add(AIOGalleryUtils.a((MessageForPic)localObject2));
                localArrayList2.add((MessageForPic)localObject2);
              }
            }
          }
          else if ((localObject1 instanceof MessageForStructing))
          {
            MessageForStructing localMessageForStructing = (MessageForStructing)localObject1;
            localMessageForStructing.parse();
            if ((localMessageForStructing.structingMsg != null) && (localMessageForStructing.structingMsg.mMsgServiceID == 5))
            {
              StructMsgForImageShare localStructMsgForImageShare = (StructMsgForImageShare)localMessageForStructing.structingMsg;
              StructMsgItemImage localStructMsgItemImage = localStructMsgForImageShare.getFirstImageElement();
              if (localStructMsgItemImage != null)
              {
                localObject2 = localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqDataMessageForPic;
                localObject1 = localObject2;
                if (localObject2 == null)
                {
                  if (localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare == null) {
                    localStructMsgItemImage.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForImageShare = localStructMsgForImageShare;
                  }
                  localObject1 = localStructMsgItemImage.a();
                }
                localObject2 = AIOGalleryUtils.a((MessageForPic)localObject1);
                ((AIOImageData)localObject2).jdField_g_of_type_Long = localMessageForStructing.time;
                if ((localStructMsgForImageShare.mMsgActionData != null) && (localStructMsgForImageShare.mMsgActionData.startsWith("comic_plugin.apk")))
                {
                  ((AIOImageData)localObject2).h = 1;
                  ((AIOImageData)localObject2).jdField_a_of_type_JavaLangObject = localStructMsgForImageShare.getBytes();
                  ((AIOImageData)localObject2).j = AIOGallerySceneWithBusiness.a(AIOGallerySceneWithBusiness.a(localStructMsgForImageShare));
                }
                localArrayList1.add(localObject2);
                localArrayList2.add(localObject1);
              }
            }
          }
          else if (MessageForShortVideo.class.isInstance(localObject1))
          {
            localObject1 = (MessageForShortVideo)localObject1;
            if ((((MessageForShortVideo)localObject1).busiType == 1) || (((MessageForShortVideo)localObject1).busiType == 2) || (((MessageForShortVideo)localObject1).busiType == 1007) || (((MessageForShortVideo)localObject1).busiType == 1009) || (((MessageForShortVideo)localObject1).busiType == 0))
            {
              localArrayList1.add(AIOGalleryUtils.a((MessageForShortVideo)localObject1));
              localArrayList2.add(localObject1);
            }
          }
          else if ((localObject1 instanceof MessageForFile))
          {
            localObject1 = (MessageForFile)localObject1;
            localObject2 = paramQQAppInterface.a().a(((MessageForFile)localObject1).uniseq, ((MessageForFile)localObject1).frienduin, ((MessageForFile)localObject1).istroop);
            int m = 0;
            int n = 0;
            int j = n;
            i = m;
            if (localObject2 != null)
            {
              j = n;
              i = m;
              if (16 != ((FileManagerEntity)localObject2).status)
              {
                j = FileManagerUtil.a(((FileManagerEntity)localObject2).fileName);
                if (j != 0) {
                  break label738;
                }
                i = 1;
                label695:
                if (j != 2) {
                  break label744;
                }
              }
            }
            label738:
            label744:
            for (j = 1;; j = 0)
            {
              if (i == 0) {
                break label750;
              }
              ((MessageForFile)localObject1).parse();
              localArrayList1.add(AIOGalleryUtils.a((MessageForFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
              break;
              i = 0;
              break label695;
            }
            label750:
            if (j != 0)
            {
              ((MessageForFile)localObject1).parse();
              localArrayList1.add(AIOGalleryUtils.a((MessageForFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
            }
            else if (QLog.isColorLevel())
            {
              QLog.i("AIOImageProviderService", 2, "ignore filePic: " + localObject1);
            }
          }
          else if ((localObject1 instanceof MessageForTroopFile))
          {
            localObject1 = (MessageForTroopFile)localObject1;
            if ((FileManagerUtil.a(((MessageForTroopFile)localObject1).fileName) == 0) && (((MessageForTroopFile)localObject1).fileSize < 10485760L)) {}
            for (i = 1;; i = 0)
            {
              if (i == 0) {
                break label889;
              }
              localArrayList1.add(AIOGalleryUtils.a((MessageForTroopFile)localObject1, paramQQAppInterface));
              localArrayList2.add(localObject1);
              break;
            }
          }
          else
          {
            label889:
            if (QLog.isColorLevel()) {
              QLog.i("AIOImageProviderService", 2, "messageRecordToData " + ((MessageRecord)localObject1).getBaseInfoString());
            }
          }
        }
      }
    }
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaUtilList.addAll(0, localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(0, localArrayList1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "messageRecordToData total size " + localArrayList2.size() + ", cost " + (System.currentTimeMillis() - l));
      }
      return localArrayList1;
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilList.addAll(localArrayList2);
      this.jdField_b_of_type_JavaUtilList.addAll(localArrayList1);
    }
  }
  
  private ChatMessage b(long paramLong1, long paramLong2)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator.hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)localIterator.next();
          if (MessageForPic.class.isInstance(localChatMessage))
          {
            MessageForPic localMessageForPic = (MessageForPic)localChatMessage;
            if ((paramLong1 != localMessageForPic.uniseq) || (paramLong2 != localMessageForPic.subMsgId)) {
              continue;
            }
            return localChatMessage;
          }
          if (paramLong1 != localChatMessage.uniseq) {
            continue;
          }
        }
      }
      Object localObject2 = null;
    }
  }
  
  public Intent a(long paramLong, int paramInt)
  {
    long l = paramInt;
    try
    {
      Object localObject1 = b(paramLong, l);
      if ((localObject1 != null) && (MessageForPic.class.isInstance(localObject1)))
      {
        Object localObject2 = (MessageForPic)localObject1;
        localObject2 = (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString);
        localObject1 = QfavBuilder.a((Entity)localObject1).b((QQAppInterface)localObject2, (MessageRecord)localObject1).a();
        return (Intent)localObject1;
      }
    }
    catch (AccountNotMatchException localAccountNotMatchException)
    {
      throw new IllegalArgumentException("no appRuntime", localAccountNotMatchException);
    }
    throw new IllegalArgumentException("message not find..");
  }
  
  public Intent a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = b(paramLong, paramInt1);
    if (localObject != null)
    {
      if (!MessageForPic.class.isInstance(localObject)) {
        break label52;
      }
      localObject = (MessageForPic)localObject;
      if ((((MessageForPic)localObject).uniseq != paramLong) || (((MessageForPic)localObject).subMsgId != paramInt1)) {}
    }
    return null;
    label52:
    Intent localIntent;
    if (MessageForShortVideo.class.isInstance(localObject))
    {
      localObject = (MessageForShortVideo)localObject;
      if (((MessageForShortVideo)localObject).uniseq != paramLong) {
        break label150;
      }
      localIntent = a((MessageForShortVideo)localObject);
      localObject = localIntent;
      if (localIntent != null) {
        localIntent.putExtra("from_uin_type", paramInt2);
      }
    }
    label150:
    for (localObject = localIntent;; localObject = null)
    {
      return (Intent)localObject;
      if (!MessageForFile.class.isInstance(localObject)) {
        break;
      }
      localObject = (MessageForFile)localObject;
      if (((MessageForFile)localObject).uniseq != paramLong) {
        break;
      }
      return a((MessageForFile)localObject);
    }
  }
  
  public Intent a(MessageForFile paramMessageForFile)
  {
    try
    {
      FileManagerEntity localFileManagerEntity = ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString)).a().a(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (localFileManagerEntity == null) {
        return null;
      }
      Intent localIntent = new Intent();
      localIntent.setExtrasClassLoader(ForwardFileInfo.class.getClassLoader());
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 0);
      localBundle.putBoolean("not_forward", true);
      localBundle.putParcelable("fileinfo", ForwardFileOption.a(localFileManagerEntity, paramMessageForFile));
      localBundle.putString("forward_text", "已选择" + FileManagerUtil.d(localFileManagerEntity.fileName) + "。");
      localBundle.putBoolean("direct_send_if_dataline_forward", true);
      localBundle.putString("forward_filepath", localFileManagerEntity.getFilePath());
      localBundle.putBoolean("k_favorites", FileManagerUtil.c(localFileManagerEntity));
      if ((localFileManagerEntity.getCloudType() == 6) || (localFileManagerEntity.getCloudType() == 7))
      {
        localBundle.putBoolean("isFromShare", true);
        if (localFileManagerEntity.nFileType == 0) {
          localBundle.putInt("forward_type", 1);
        }
      }
      if ((localFileManagerEntity.getCloudType() == 8) && (localFileManagerEntity.nFileType == 0)) {
        localBundle.putInt("forward_type", 1);
      }
      localIntent.putExtras(localBundle);
      return localIntent;
    }
    catch (AccountNotMatchException paramMessageForFile)
    {
      paramMessageForFile.printStackTrace();
    }
    return null;
  }
  
  public Intent a(MessageForShortVideo paramMessageForShortVideo)
  {
    if (TextUtils.isEmpty(paramMessageForShortVideo.md5))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "Forward menu clicked, md5 is empty.");
      }
      return null;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 21);
    String str1 = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
    localBundle.putString("forward_thumb", str1);
    localBundle.putString("from_uin", ShortVideoUtils.c(paramMessageForShortVideo));
    localBundle.putInt("from_busi_type", paramMessageForShortVideo.busiType);
    localBundle.putInt("file_send_size", paramMessageForShortVideo.videoFileSize);
    localBundle.putInt("file_send_duration", paramMessageForShortVideo.videoFileTime);
    localBundle.putString("file_name", paramMessageForShortVideo.videoFileName);
    localBundle.putInt("file_format", paramMessageForShortVideo.videoFileFormat);
    localBundle.putBoolean("forward_need_sendmsg", true);
    String str2 = ShortVideoUtils.b(paramMessageForShortVideo);
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "Forward menu clicked, videoPath=" + str2 + ",videoPath = " + str2 + ", " + paramMessageForShortVideo.toLogString());
    }
    localBundle.putString("file_send_path", str2);
    localBundle.putString("thumbfile_send_path", str1);
    localBundle.putString("file_shortvideo_md5", paramMessageForShortVideo.md5);
    localBundle.putInt("thumbfile_send_width", paramMessageForShortVideo.thumbWidth);
    localBundle.putInt("thumbfile_send_height", paramMessageForShortVideo.thumbHeight);
    localBundle.putString("thumbfile_md5", paramMessageForShortVideo.thumbMD5);
    localBundle.putString("file_source", paramMessageForShortVideo.fileSource);
    localBundle.putString("file_uuid", paramMessageForShortVideo.uuid);
    localBundle.putInt("file_thumb_Size", paramMessageForShortVideo.thumbFileSize);
    return new Intent().putExtras(localBundle);
  }
  
  /* Error */
  public ChatMessage a(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 51	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   7: astore 7
    //   9: aload 7
    //   11: monitorenter
    //   12: iconst_0
    //   13: istore 10
    //   15: iload 10
    //   17: aload_0
    //   18: getfield 51	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   21: invokeinterface 183 1 0
    //   26: if_icmpge +216 -> 242
    //   29: aload_0
    //   30: getfield 51	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   33: iload 10
    //   35: invokeinterface 186 2 0
    //   40: checkcast 79	com/tencent/mobileqq/data/ChatMessage
    //   43: astore 5
    //   45: ldc -51
    //   47: aload 5
    //   49: invokevirtual 112	java/lang/Class:isInstance	(Ljava/lang/Object;)Z
    //   52: ifeq +143 -> 195
    //   55: aload 5
    //   57: checkcast 205	com/tencent/mobileqq/data/MessageForPic
    //   60: astore 8
    //   62: lload_1
    //   63: aload 8
    //   65: getfield 393	com/tencent/mobileqq/data/MessageForPic:uniseq	J
    //   68: lcmp
    //   69: ifne +183 -> 252
    //   72: lload_3
    //   73: aload 8
    //   75: getfield 396	com/tencent/mobileqq/data/MessageForPic:subMsgId	I
    //   78: i2l
    //   79: lcmp
    //   80: ifne +172 -> 252
    //   83: iconst_1
    //   84: istore 9
    //   86: iload 9
    //   88: ifeq +15 -> 103
    //   91: aload_0
    //   92: getfield 51	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   95: iload 10
    //   97: invokeinterface 623 2 0
    //   102: pop
    //   103: aload 7
    //   105: monitorexit
    //   106: aload_0
    //   107: getfield 53	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   110: astore 6
    //   112: aload 6
    //   114: monitorenter
    //   115: iconst_0
    //   116: istore 9
    //   118: iload 9
    //   120: aload_0
    //   121: getfield 53	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   124: invokeinterface 183 1 0
    //   129: if_icmpge +107 -> 236
    //   132: aload_0
    //   133: getfield 53	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   136: iload 9
    //   138: invokeinterface 186 2 0
    //   143: checkcast 625	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData
    //   146: astore 7
    //   148: aload 7
    //   150: getfield 628	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:f	J
    //   153: lload_1
    //   154: lcmp
    //   155: ifne +64 -> 219
    //   158: aload 7
    //   160: getfield 631	com/tencent/mobileqq/activity/aio/photo/AIORichMediaData:k	I
    //   163: i2l
    //   164: lload_3
    //   165: lcmp
    //   166: ifne +53 -> 219
    //   169: iconst_1
    //   170: istore 10
    //   172: iload 10
    //   174: ifeq +15 -> 189
    //   177: aload_0
    //   178: getfield 53	com/tencent/mobileqq/activity/aio/photo/AIOImageProviderService:jdField_b_of_type_JavaUtilList	Ljava/util/List;
    //   181: iload 9
    //   183: invokeinterface 623 2 0
    //   188: pop
    //   189: aload 6
    //   191: monitorexit
    //   192: aload 5
    //   194: areturn
    //   195: lload_1
    //   196: aload 5
    //   198: getfield 159	com/tencent/mobileqq/data/ChatMessage:uniseq	J
    //   201: lcmp
    //   202: ifne +50 -> 252
    //   205: iconst_1
    //   206: istore 9
    //   208: goto -122 -> 86
    //   211: astore 5
    //   213: aload 7
    //   215: monitorexit
    //   216: aload 5
    //   218: athrow
    //   219: iload 9
    //   221: iconst_1
    //   222: iadd
    //   223: istore 9
    //   225: goto -107 -> 118
    //   228: astore 5
    //   230: aload 6
    //   232: monitorexit
    //   233: aload 5
    //   235: athrow
    //   236: iconst_0
    //   237: istore 10
    //   239: goto -67 -> 172
    //   242: iconst_0
    //   243: istore 9
    //   245: aload 6
    //   247: astore 5
    //   249: goto -163 -> 86
    //   252: iload 10
    //   254: iconst_1
    //   255: iadd
    //   256: istore 10
    //   258: goto -243 -> 15
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	261	0	this	AIOImageProviderService
    //   0	261	1	paramLong1	long
    //   0	261	3	paramLong2	long
    //   43	154	5	localChatMessage	ChatMessage
    //   211	6	5	localObject1	Object
    //   228	6	5	localObject2	Object
    //   247	1	5	localList1	List
    //   1	245	6	localList2	List
    //   7	207	7	localObject3	Object
    //   60	14	8	localMessageForPic	MessageForPic
    //   84	160	9	i	int
    //   13	244	10	j	int
    // Exception table:
    //   from	to	target	type
    //   15	83	211	finally
    //   91	103	211	finally
    //   103	106	211	finally
    //   195	205	211	finally
    //   213	216	211	finally
    //   118	169	228	finally
    //   177	189	228	finally
    //   189	192	228	finally
    //   230	233	228	finally
  }
  
  public MessageForShortVideo a(long paramLong)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilList)
      {
        Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          ChatMessage localChatMessage = (ChatMessage)((Iterator)localObject1).next();
          if ((paramLong != localChatMessage.uniseq) || (!MessageForShortVideo.class.isInstance(localChatMessage))) {
            continue;
          }
          localObject1 = (MessageForShortVideo)localChatMessage;
          return (MessageForShortVideo)localObject1;
        }
      }
      Object localObject3 = null;
    }
  }
  
  public void a()
  {
    super.a();
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "[destroy] " + this.jdField_b_of_type_JavaLangString + "_" + this.jdField_c_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_b_of_type_JavaUtilList.clear();
    jdField_a_of_type_JavaUtilHashMap.remove(this.jdField_b_of_type_JavaLangString + "_" + this.jdField_c_of_type_JavaLangString + "_" + this.jdField_a_of_type_Int);
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener = null;
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener == null)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "[loadMedias] + loadType: " + paramInt + ", dataList.size = " + this.jdField_b_of_type_JavaUtilList.size());
      }
      switch (paramInt)
      {
      default: 
        return;
      case 0: 
        this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new nuq(this));
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack == null);
    ArrayList localArrayList;
    if (this.jdField_b_of_type_JavaUtilList.size() > 0)
    {
      localArrayList = new ArrayList();
      ??? = this.jdField_b_of_type_JavaUtilList;
      paramInt = 0;
    }
    for (;;)
    {
      try
      {
        if (paramInt < this.jdField_b_of_type_JavaUtilList.size())
        {
          AIORichMediaData localAIORichMediaData = (AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(paramInt);
          if (a(localAIORichMediaData)) {
            break label340;
          }
          localArrayList.add(localAIORichMediaData);
        }
      }
      finally {}
      ??? = (AIORichMediaData[])((List)localObject2).toArray(new AIORichMediaData[((List)localObject2).size()]);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack.a((AIORichMediaData[])???, -1);
      return;
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new nuq(this));
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener == null) {
        break;
      }
      if (this.jdField_b_of_type_JavaUtilList.size() > 0) {
        synchronized (this.jdField_b_of_type_JavaUtilList)
        {
          AIORichMediaData[] arrayOfAIORichMediaData = (AIORichMediaData[])this.jdField_b_of_type_JavaUtilList.toArray(new AIORichMediaData[this.jdField_b_of_type_JavaUtilList.size()]);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener.a(arrayOfAIORichMediaData, -1);
          return;
        }
      }
      this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.post(new nuq(this));
      return;
      label340:
      paramInt += 1;
    }
  }
  
  public void a(long paramLong)
  {
    ThreadManager.a().post(new nup(this, paramLong));
  }
  
  public void a(long paramLong, int paramInt)
  {
    ThreadManager.a().post(new nuo(this, paramLong, paramInt));
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = b(paramLong, paramInt1);
    if (localObject != null)
    {
      if (!MessageForPic.class.isInstance(localObject)) {
        break label38;
      }
      a((MessageForPic)localObject, paramLong, paramInt1, paramInt2);
    }
    label38:
    do
    {
      return;
      if (MessageForShortVideo.class.isInstance(localObject))
      {
        a((MessageForShortVideo)localObject, paramLong, paramInt1, paramInt2);
        return;
      }
    } while (!MessageForFile.class.isInstance(localObject));
    localObject = (MessageForFile)localObject;
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new nuj(this, (MessageForFile)localObject, paramLong, paramInt1, paramInt2));
      return;
    }
    a((MessageForFile)localObject, paramLong, paramInt1, paramInt2);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2, String paramString)
  {
    List localList = this.jdField_b_of_type_JavaUtilList;
    int i = 0;
    for (;;)
    {
      Object localObject;
      try
      {
        if (i >= this.jdField_b_of_type_JavaUtilList.size()) {
          break label517;
        }
        localObject = (AIORichMediaData)this.jdField_b_of_type_JavaUtilList.get(i);
        if (!AIOImageData.class.isInstance(localObject)) {
          break label277;
        }
        localObject = (AIOImageData)localObject;
        if ((((AIOImageData)localObject).f != paramLong) || (((AIOImageData)localObject).k != paramInt1)) {
          break label651;
        }
        if (!"I:E".equals(paramString)) {
          break label524;
        }
        switch (paramInt2)
        {
        case 3: 
          return;
        }
      }
      finally {}
      ((AIOImageData)localObject).jdField_b_of_type_Boolean = true;
      continue;
      ((AIOImageData)localObject).jdField_c_of_type_Boolean = true;
      continue;
      ((AIOImageData)localObject).jdField_a_of_type_Boolean = true;
      continue;
      ((AIOImageData)localObject).jdField_a_of_type_JavaLangString = paramString;
      continue;
      ((AIOImageData)localObject).jdField_b_of_type_JavaLangString = paramString;
      if ((!((AIOImageData)localObject).jdField_g_of_type_Boolean) && (new File(((AIOImageData)localObject).jdField_a_of_type_JavaLangString + "_hd").exists()))
      {
        ((AIOImageData)localObject).jdField_a_of_type_JavaLangString += "_hd";
        continue;
        ((AIOImageData)localObject).jdField_c_of_type_JavaLangString = paramString;
        continue;
        ((AIOImageData)localObject).d = paramString;
        continue;
        label277:
        if (AIOShortVideoData.class.isInstance(localObject))
        {
          localObject = (AIOShortVideoData)localObject;
          if (((AIOShortVideoData)localObject).f != paramLong) {
            break label651;
          }
          if (!"I:E".equals(paramString)) {}
        }
        else
        {
          switch (paramInt2)
          {
          case 0: 
          case 1: 
            for (;;)
            {
              label340:
              return;
              ((AIOShortVideoData)localObject).jdField_a_of_type_Boolean = true;
              continue;
              ((AIOShortVideoData)localObject).jdField_b_of_type_Boolean = true;
              continue;
              ((AIOShortVideoData)localObject).jdField_a_of_type_JavaLangString = paramString;
              continue;
              ((AIOShortVideoData)localObject).jdField_b_of_type_JavaLangString = paramString;
            }
            if (!AIOFilePicData.class.isInstance(localObject)) {
              break label651;
            }
            localObject = (AIOFilePicData)localObject;
            if (((AIOFilePicData)localObject).f != paramLong) {
              break label651;
            }
            if ("I:E".equals(paramString)) {
              switch (paramInt2)
              {
              }
            }
            break;
          }
        }
        for (;;)
        {
          return;
          ((AIOFilePicData)localObject).jdField_a_of_type_Boolean = true;
          continue;
          ((AIOFilePicData)localObject).jdField_b_of_type_Boolean = true;
          continue;
          ((AIOFilePicData)localObject).jdField_c_of_type_Boolean = true;
          continue;
          ((AIOFilePicData)localObject).jdField_b_of_type_JavaLangString = paramString;
          continue;
          ((AIOFilePicData)localObject).jdField_c_of_type_JavaLangString = paramString;
          continue;
          ((AIOFilePicData)localObject).d = paramString;
          continue;
          label517:
          return;
          break;
          label524:
          switch (paramInt2)
          {
          }
          break;
          break label340;
          switch (paramInt2)
          {
          }
          break label340;
          continue;
          switch (paramInt2)
          {
          }
        }
        label651:
        i += 1;
      }
    }
  }
  
  public void a(AIOImageProviderService.AIOImageProviderListener paramAIOImageProviderListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener = paramAIOImageProviderListener;
  }
  
  protected void a(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOImageProviderService", 2, "actbarmemoryleaktest ProgressEvent this " + this + " is added");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new nuk(this);
      paramQQAppInterface.a().addObserver(this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, MessageForPic paramMessageForPic)
  {
    if ((paramQQAppInterface == null) || (paramMessageForPic == null)) {
      return;
    }
    ((PicStatisticsManager)paramQQAppInterface.getManager(72)).d(paramMessageForPic);
    paramQQAppInterface = paramQQAppInterface.a();
    paramQQAppInterface.a.b(paramMessageForPic, paramMessageForPic.size);
    paramQQAppInterface.f();
  }
  
  public void a(MessageForFile paramMessageForFile, long paramLong, int paramInt1, int paramInt2)
  {
    AppRuntime localAppRuntime;
    try
    {
      localAppRuntime = BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString);
      paramMessageForFile = ((QQAppInterface)localAppRuntime).a().b(paramMessageForFile.uniseq, paramMessageForFile.frienduin, paramMessageForFile.istroop);
      if (paramMessageForFile == null) {
        return;
      }
      FileManagerEntity localFileManagerEntity = ((QQAppInterface)localAppRuntime).a().a(paramMessageForFile.nSessionId);
      if (localFileManagerEntity != null) {
        paramMessageForFile = localFileManagerEntity;
      }
      if (this.jdField_c_of_type_JavaUtilList == null) {
        this.jdField_c_of_type_JavaUtilList = new ArrayList();
      }
      this.jdField_c_of_type_JavaUtilList.add(paramMessageForFile);
      a((QQAppInterface)localAppRuntime);
      switch (paramInt2)
      {
      case 16: 
        ((QQAppInterface)localAppRuntime).a().a(paramMessageForFile, 5);
        return;
      }
    }
    catch (AccountNotMatchException paramMessageForFile)
    {
      paramMessageForFile.printStackTrace();
      return;
    }
    ((QQAppInterface)localAppRuntime).a().a(paramMessageForFile, 7);
    return;
    ((QQAppInterface)localAppRuntime).a().b(paramMessageForFile);
    return;
  }
  
  public void a(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    PicReq localPicReq;
    int i;
    switch (paramInt2)
    {
    case 3: 
    default: 
      return;
    case 2: 
      localPicReq = PicBusiManager.a(6, 1536, 1);
      i = 1;
    }
    for (;;)
    {
      try
      {
        localPicReq.a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
        String str = AbsDownloader.d(URLDrawableHelper.a(paramMessageForPic, i, null).toString().toString());
        localPicReq.a(new num(this, paramLong, paramInt1, paramInt2, paramMessageForPic.size, str));
        PicBusiManager.a(localPicReq, (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString));
        return;
      }
      catch (AccountNotMatchException paramMessageForPic) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
      return;
      localPicReq = PicBusiManager.a(7, 1);
      i = 131075;
      continue;
      localPicReq = PicBusiManager.a(5, 1);
      i = 65537;
    }
  }
  
  public void a(MessageForShortVideo paramMessageForShortVideo, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      ShortVideoReq localShortVideoReq = ShortVideoBusiManager.a(2, 2);
      ShortVideoDownloadInfo localShortVideoDownloadInfo = paramMessageForShortVideo.getDownloadInfo(localShortVideoReq.g);
      if (paramInt2 == 0)
      {
        localShortVideoDownloadInfo.i = ShortVideoUtils.a(paramMessageForShortVideo.thumbMD5, "jpg");
        localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 1);
      }
      for (;;)
      {
        localShortVideoReq.a(localShortVideoDownloadInfo);
        localShortVideoReq.a(new nun(this, paramLong, paramInt1, paramInt2));
        ShortVideoBusiManager.a(localShortVideoReq, (QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString));
        return;
        localShortVideoDownloadInfo.h = ShortVideoUtils.a(paramMessageForShortVideo, "mp4");
        localShortVideoDownloadInfo.a(paramMessageForShortVideo.istroop, 0);
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForShortVideo)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOImageProviderService", 2, "no appRuntime");
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOImageProviderService", 2, "reportData,sendReportType:" + paramString + ",count:" + paramInt);
    }
    try
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString);
      if (paramInt == 55)
      {
        StatisticConstants.a(paramString, this.jdField_a_of_type_Int, (QQAppInterface)localAppRuntime);
        return;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(localAppRuntime, this.jdField_b_of_type_JavaLangString, "Pic", paramString, 0, 1, null, String.valueOf(paramInt), null, null, null);
      return;
    }
    catch (AccountNotMatchException paramString)
    {
      throw new IllegalArgumentException("no appRuntime", paramString);
    }
  }
  
  public boolean a(AIORichMediaData paramAIORichMediaData)
  {
    if (AIOShortVideoData.class.isInstance(paramAIORichMediaData))
    {
      if (((AIOShortVideoData)paramAIORichMediaData).jdField_d_of_type_Int != 0) {}
    }
    else {
      while (AIOFileVideoData.class.isInstance(paramAIORichMediaData)) {
        return true;
      }
    }
    return false;
  }
  
  public void b()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack;
    if (localObject != null) {
      ((IAIOImageProviderCallBack)localObject).a(null, -1);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener;
    if (localObject != null) {
      ((AIOImageProviderService.AIOImageProviderListener)localObject).a(null, -1);
    }
  }
  
  public void b(long paramLong)
  {
    Object localObject = a(paramLong);
    if ((localObject != null) && (MessageForFile.class.isInstance(localObject)))
    {
      localObject = (MessageForFile)localObject;
      if (((MessageForFile)localObject).uniseq == paramLong)
      {
        AppRuntime localAppRuntime;
        FileManagerEntity localFileManagerEntity;
        for (;;)
        {
          try
          {
            localAppRuntime = BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString);
            localFileManagerEntity = ((QQAppInterface)localAppRuntime).a().a(((MessageForFile)localObject).uniseq, ((MessageForFile)localObject).frienduin, ((MessageForFile)localObject).istroop);
            if (localFileManagerEntity == null) {
              return;
            }
            switch (localFileManagerEntity.getCloudType())
            {
            case 1: 
              if (((MessageForFile)localObject).isSend())
              {
                localObject = ((QQAppInterface)localAppRuntime).a();
                ((QQAppInterface)localAppRuntime).a().a(localFileManagerEntity, (String)localObject);
                return;
              }
              break;
            }
          }
          catch (AccountNotMatchException localAccountNotMatchException)
          {
            localAccountNotMatchException.printStackTrace();
            return;
          }
          String str = localFileManagerEntity.peerUin;
        }
        ((QQAppInterface)localAppRuntime).a().a(localFileManagerEntity.getFilePath(), null, localAppRuntime.getAccount(), 0, false);
      }
    }
    return;
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    ChatMessage localChatMessage = b(paramLong, paramInt1);
    if (localChatMessage != null)
    {
      if (!MessageForPic.class.isInstance(localChatMessage)) {
        break label38;
      }
      b((MessageForPic)localChatMessage, paramLong, paramInt1, paramInt2);
    }
    label38:
    while ((MessageForShortVideo.class.isInstance(localChatMessage)) || (!MessageForFile.class.isInstance(localChatMessage))) {
      return;
    }
  }
  
  public void b(MessageForPic paramMessageForPic, long paramLong, int paramInt1, int paramInt2)
  {
    try
    {
      paramMessageForPic = ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString)).a().a(TransFileController.a(paramMessageForPic.md5, paramMessageForPic.uuid, 131075));
      if ((paramMessageForPic instanceof C2CPicDownloadProcessor))
      {
        if (QLog.isColorLevel()) {
          QLog.d("AIOImageProviderService", 2, "destroy cancel processor:" + paramMessageForPic);
        }
        ((BaseDownloadProcessor)paramMessageForPic).b();
      }
      return;
    }
    catch (AccountNotMatchException paramMessageForPic)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("AIOImageProviderService", 2, "no appRuntime");
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageProviderService$AIOImageProviderListener = null;
  }
  
  public void c(long paramLong)
  {
    Object localObject = a(paramLong);
    if ((localObject != null) && (MessageForFile.class.isInstance(localObject)))
    {
      localObject = (MessageForFile)localObject;
      try
      {
        localObject = ((QQAppInterface)BaseApplicationImpl.a.getAppRuntime(this.jdField_b_of_type_JavaLangString)).a().a(((MessageForFile)localObject).uniseq, ((MessageForFile)localObject).frienduin, ((MessageForFile)localObject).istroop);
        if (localObject == null) {
          return;
        }
        Intent localIntent = new Intent(BaseActivity.sTopActivity, FilePicQFavActivity.class);
        localIntent.putExtra("file_pic_favorites", ((FileManagerEntity)localObject).nSessionId);
        BaseActivity.sTopActivity.startActivity(localIntent);
        return;
      }
      catch (AccountNotMatchException localAccountNotMatchException)
      {
        localAccountNotMatchException.printStackTrace();
      }
    }
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProviderCallBack = null;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\aio\photo\AIOImageProviderService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */