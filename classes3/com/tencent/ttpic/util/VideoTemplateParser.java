package com.tencent.ttpic.util;

import android.text.TextUtils;
import com.tencent.ttpic.model.DistortionItem;
import com.tencent.ttpic.model.FaceMoveItem;
import com.tencent.ttpic.model.StickerItem;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.util.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoTemplateParser
{
  public static final String POSTFIX_DAT = "dat";
  private static final String POSTFIX_JSON = "json";
  
  private static InputStream drinkACupOfCoffee(InputStream paramInputStream, DecryptListener paramDecryptListener)
    throws IOException
  {
    byte[] arrayOfByte = IOUtils.toByteArray(paramInputStream);
    paramInputStream = arrayOfByte;
    if (paramDecryptListener != null) {
      paramInputStream = paramDecryptListener.decrypt(arrayOfByte);
    }
    return new ByteArrayInputStream(paramInputStream);
  }
  
  public static VideoMaterial parseVideoMaterial(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    VideoMaterial localVideoMaterial = new VideoMaterial();
    localVideoMaterial.setDataPath(paramString1);
    paramString2 = parseVideoMaterialFile(paramString1, paramString2, paramBoolean, paramDecryptListener);
    if (paramString2 == null) {
      return localVideoMaterial;
    }
    for (;;)
    {
      int k;
      try
      {
        localVideoMaterial.setMinAppVersion(paramString2.optInt(VideoMaterialUtil.FIELD.MIN_APP_VERSION.value));
        localVideoMaterial.setShaderType(paramString2.optInt(VideoMaterialUtil.FIELD.SHADER_TYPE.value));
        localVideoMaterial.setFaceoffType(paramString2.optInt(VideoMaterialUtil.FIELD.FACE_OFF_TYPE.value));
        localVideoMaterial.setMaxFaceCount(paramString2.optInt(VideoMaterialUtil.FIELD.MAX_FACE_COUNT.value));
        localVideoMaterial.setFaceExchangeImage(paramString2.optString(VideoMaterialUtil.FIELD.FACE_EXCHANGE_IMAGE.value));
        localVideoMaterial.setImageFacePointsFileName(paramString2.optString(VideoMaterialUtil.FIELD.IMAGE_FACE_POINTS_FILE_NAME.value));
        localVideoMaterial.setBlendAlpha(paramString2.optDouble(VideoMaterialUtil.FIELD.BLEND_ALPHA.value));
        localVideoMaterial.setGrayScale(paramString2.optInt(VideoMaterialUtil.FIELD.GRAY_SCALE.value));
        localVideoMaterial.setOrderMode(paramString2.optInt(VideoMaterialUtil.FIELD.ORDER_MODE.value));
        localVideoMaterial.setBlendMode(paramString2.optInt(VideoMaterialUtil.FIELD.BLEND_MODE.value));
        localVideoMaterial.setFeatureType(paramString2.optInt(VideoMaterialUtil.FIELD.FEATURE_TYPE.value));
        paramDecryptListener = new ArrayList();
        Object localObject = paramString2.optJSONArray(VideoMaterialUtil.FIELD.RESOURCE_LIST.value);
        int i;
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            paramDecryptListener.add(((JSONArray)localObject).optString(i));
            i += 1;
            continue;
          }
          localVideoMaterial.setResourceList(paramDecryptListener);
        }
        k = 0;
        paramDecryptListener = new ArrayList();
        localObject = paramString2.optJSONArray(VideoMaterialUtil.FIELD.ITEM_LIST.value);
        JSONObject localJSONObject;
        if (localObject != null)
        {
          i = 0;
          if (i < ((JSONArray)localObject).length())
          {
            localJSONObject = ((JSONArray)localObject).getJSONObject(i);
            StickerItem localStickerItem = new StickerItem();
            localStickerItem.id = localJSONObject.optString("id");
            localStickerItem.name = localJSONObject.optString("name");
            localStickerItem.type = localJSONObject.optInt("type");
            localStickerItem.blendMode = localJSONObject.optInt("blendMode", -1);
            if (localStickerItem.blendMode == -1) {
              localStickerItem.blendMode = localVideoMaterial.getBlendMode();
            }
            localStickerItem.triggerType = localJSONObject.optInt("triggerType");
            if (VideoMaterialUtil.isActionTriggerType(localStickerItem.triggerType)) {
              localVideoMaterial.setTriggerType(localStickerItem.triggerType);
            }
            if (localJSONObject.optInt("alwaysTriggered") == 1)
            {
              paramBoolean = true;
              localStickerItem.alwaysTriggered = paramBoolean;
              localStickerItem.playCount = localJSONObject.optInt("playCount");
              localStickerItem.frameDuration = localJSONObject.optDouble("frameDuration");
              localStickerItem.frames = localJSONObject.optInt("frames");
              localStickerItem.width = localJSONObject.optInt("width");
              localStickerItem.height = localJSONObject.optInt("height");
              JSONArray localJSONArray = localJSONObject.optJSONArray("position");
              if (localJSONArray != null)
              {
                localStickerItem.position = new double[localJSONArray.length()];
                j = 0;
                if (j < localJSONArray.length())
                {
                  localStickerItem.position[j] = localJSONArray.getDouble(j);
                  j += 1;
                  continue;
                }
              }
              localStickerItem.audio = localJSONObject.optString("audio");
              j = k;
              if (!TextUtils.isEmpty(localStickerItem.audio))
              {
                j = k;
                if (!TextUtils.isEmpty(paramString1))
                {
                  if (paramString1.startsWith("assets://camera/camera_video/video_")) {
                    break label1400;
                  }
                  j = k;
                  if (paramString1.contains("/files/olm/camera/video_")) {
                    break label1400;
                  }
                }
              }
              localJSONArray = localJSONObject.optJSONArray("anchorPoint");
              if (localJSONArray != null)
              {
                localStickerItem.anchorPoint = new int[localJSONArray.length()];
                k = 0;
                if (k < localJSONArray.length())
                {
                  localStickerItem.anchorPoint[k] = localJSONArray.getInt(k);
                  k += 1;
                  continue;
                }
              }
              localJSONArray = localJSONObject.optJSONArray("alignFacePoints");
              if (localJSONArray != null)
              {
                localStickerItem.alignFacePoints = new int[localJSONArray.length()];
                k = 0;
                if (k < localJSONArray.length())
                {
                  localStickerItem.alignFacePoints[k] = localJSONArray.getInt(k);
                  k += 1;
                  continue;
                }
              }
              localJSONArray = localJSONObject.optJSONArray("scalePivots");
              if (localJSONArray != null)
              {
                localStickerItem.scalePivots = new int[localJSONArray.length()];
                k = 0;
                if (k < localJSONArray.length())
                {
                  localStickerItem.scalePivots[k] = localJSONArray.getInt(k);
                  k += 1;
                  continue;
                }
              }
              localStickerItem.scaleFactor = localJSONObject.optInt("scaleFactor");
              paramDecryptListener.add(localStickerItem);
              i += 1;
              k = j;
            }
          }
          else
          {
            localVideoMaterial.setItemList(paramDecryptListener);
            if (k <= 0) {
              break label1409;
            }
            paramBoolean = true;
            localVideoMaterial.setHasAudio(paramBoolean);
          }
        }
        else
        {
          paramString1 = new ArrayList();
          paramDecryptListener = paramString2.optJSONArray(VideoMaterialUtil.FIELD.DISTORTION_LIST.value);
          if (paramDecryptListener != null)
          {
            i = 0;
            if (i < paramDecryptListener.length())
            {
              localObject = new DistortionItem();
              localJSONObject = paramDecryptListener.getJSONObject(i);
              ((DistortionItem)localObject).position = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.POSITION.value);
              ((DistortionItem)localObject).distortion = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DISTORTION.value);
              ((DistortionItem)localObject).direction = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.DIRECTION.value);
              ((DistortionItem)localObject).radius = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.RADIUS.value));
              ((DistortionItem)localObject).strength = ((float)localJSONObject.optDouble(VideoMaterialUtil.DISTORTION_ITEM_FILED.STRENGH.value));
              ((DistortionItem)localObject).x = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.X.value);
              ((DistortionItem)localObject).y = localJSONObject.optInt(VideoMaterialUtil.DISTORTION_ITEM_FILED.Y.value);
              paramString1.add(localObject);
              i += 1;
              continue;
            }
            localVideoMaterial.setDistortionItemList(paramString1);
          }
          paramString1 = new ArrayList();
          paramDecryptListener = paramString2.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_LIST.value);
          if (paramDecryptListener != null)
          {
            i = 0;
            if (i < paramDecryptListener.length())
            {
              localObject = new FaceMoveItem();
              localJSONObject = paramDecryptListener.getJSONObject(i);
              ((FaceMoveItem)localObject).position = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POSITION.value);
              ((FaceMoveItem)localObject).pos1 = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS1.value);
              ((FaceMoveItem)localObject).pos2 = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.POS2.value);
              ((FaceMoveItem)localObject).ratio1 = ((float)localJSONObject.optDouble(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO1.value));
              ((FaceMoveItem)localObject).ratio2 = ((float)localJSONObject.optDouble(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.RATIO2.value));
              ((FaceMoveItem)localObject).dx = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.X.value);
              ((FaceMoveItem)localObject).dy = localJSONObject.optInt(VideoMaterialUtil.FACE_MOVE_ITEM_FILED.Y.value);
              paramString1.add(localObject);
              i += 1;
              continue;
            }
            localVideoMaterial.setFaceMoveItemList(paramString1);
          }
          paramString1 = paramString2.optJSONArray(VideoMaterialUtil.FIELD.FACE_MOVE_TRIANGLE.value);
          if (paramString1 != null)
          {
            paramDecryptListener = new int[paramString1.length()];
            i = 0;
            if (i < paramString1.length())
            {
              paramDecryptListener[i] = paramString1.getInt(i);
              i += 1;
              continue;
            }
            localVideoMaterial.setFaceMoveTriangles(paramDecryptListener);
          }
          paramString1 = paramString2.optJSONArray(VideoMaterialUtil.FIELD.FACE_POINTS_LIST.value);
          paramString2 = new ArrayList();
          if (paramString1 == null) {
            break;
          }
          i = 0;
          if (i < paramString1.length())
          {
            paramString2.add(Integer.valueOf(paramString1.optInt(i)));
            i += 1;
            continue;
          }
          localVideoMaterial.setFacePoints(paramString2);
        }
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
      finally
      {
        return localVideoMaterial;
      }
      paramBoolean = false;
      continue;
      label1400:
      int j = k + 1;
      continue;
      label1409:
      paramBoolean = false;
    }
  }
  
  /* Error */
  public static JSONObject parseVideoMaterialFile(String paramString1, String paramString2, boolean paramBoolean, DecryptListener paramDecryptListener)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: aload_0
    //   7: invokestatic 436	com/tencent/ttpic/util/VideoUtil:getRealPath	(Ljava/lang/String;)Ljava/lang/String;
    //   10: astore 4
    //   12: new 438	java/lang/StringBuilder
    //   15: dup
    //   16: invokespecial 439	java/lang/StringBuilder:<init>	()V
    //   19: aload 4
    //   21: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: ldc_w 445
    //   27: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload_1
    //   31: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: ldc_w 447
    //   37: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: astore 5
    //   42: iload_2
    //   43: ifeq +496 -> 539
    //   46: ldc 11
    //   48: astore_0
    //   49: aload 5
    //   51: aload_0
    //   52: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: invokevirtual 451	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   58: astore 21
    //   60: new 438	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 439	java/lang/StringBuilder:<init>	()V
    //   67: aload 4
    //   69: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: ldc_w 445
    //   75: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: aload_1
    //   79: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc_w 447
    //   85: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: astore_1
    //   89: iload_2
    //   90: ifne +455 -> 545
    //   93: ldc 11
    //   95: astore_0
    //   96: aload_1
    //   97: aload_0
    //   98: invokevirtual 443	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: invokevirtual 451	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: astore 22
    //   106: aconst_null
    //   107: astore 19
    //   109: aconst_null
    //   110: astore 20
    //   112: aconst_null
    //   113: astore 5
    //   115: aconst_null
    //   116: astore 15
    //   118: aconst_null
    //   119: astore 10
    //   121: aconst_null
    //   122: astore 11
    //   124: aconst_null
    //   125: astore 14
    //   127: aconst_null
    //   128: astore 13
    //   130: aconst_null
    //   131: astore 12
    //   133: aconst_null
    //   134: astore 16
    //   136: aconst_null
    //   137: astore 17
    //   139: aconst_null
    //   140: astore 18
    //   142: aconst_null
    //   143: astore_0
    //   144: aload 19
    //   146: astore_1
    //   147: aload 17
    //   149: astore 6
    //   151: aload 20
    //   153: astore 4
    //   155: aload 18
    //   157: astore 7
    //   159: new 453	java/io/File
    //   162: dup
    //   163: aload 21
    //   165: invokespecial 455	java/io/File:<init>	(Ljava/lang/String;)V
    //   168: astore 24
    //   170: aload 19
    //   172: astore_1
    //   173: aload 17
    //   175: astore 6
    //   177: aload 20
    //   179: astore 4
    //   181: aload 18
    //   183: astore 7
    //   185: new 453	java/io/File
    //   188: dup
    //   189: aload 22
    //   191: invokespecial 455	java/io/File:<init>	(Ljava/lang/String;)V
    //   194: astore 23
    //   196: aload 19
    //   198: astore_1
    //   199: aload 17
    //   201: astore 6
    //   203: aload 20
    //   205: astore 4
    //   207: aload 18
    //   209: astore 7
    //   211: aload 24
    //   213: invokevirtual 459	java/io/File:exists	()Z
    //   216: ifeq +26 -> 242
    //   219: aload 19
    //   221: astore_1
    //   222: aload 17
    //   224: astore 6
    //   226: aload 20
    //   228: astore 4
    //   230: aload 18
    //   232: astore 7
    //   234: aload 24
    //   236: invokevirtual 462	java/io/File:isFile	()Z
    //   239: ifne +49 -> 288
    //   242: aload 19
    //   244: astore_1
    //   245: aload 17
    //   247: astore 6
    //   249: aload 20
    //   251: astore 4
    //   253: aload 18
    //   255: astore 7
    //   257: aload 23
    //   259: invokevirtual 459	java/io/File:exists	()Z
    //   262: ifeq +396 -> 658
    //   265: aload 19
    //   267: astore_1
    //   268: aload 17
    //   270: astore 6
    //   272: aload 20
    //   274: astore 4
    //   276: aload 18
    //   278: astore 7
    //   280: aload 23
    //   282: invokevirtual 462	java/io/File:isFile	()Z
    //   285: ifeq +373 -> 658
    //   288: aload 19
    //   290: astore_1
    //   291: aload 17
    //   293: astore 6
    //   295: aload 20
    //   297: astore 4
    //   299: aload 18
    //   301: astore 7
    //   303: aload 24
    //   305: invokevirtual 459	java/io/File:exists	()Z
    //   308: ifeq +243 -> 551
    //   311: aload 19
    //   313: astore_1
    //   314: aload 17
    //   316: astore 6
    //   318: aload 20
    //   320: astore 4
    //   322: aload 18
    //   324: astore 7
    //   326: aload 24
    //   328: invokevirtual 462	java/io/File:isFile	()Z
    //   331: ifeq +220 -> 551
    //   334: aload 19
    //   336: astore_1
    //   337: aload 17
    //   339: astore 6
    //   341: aload 20
    //   343: astore 4
    //   345: aload 18
    //   347: astore 7
    //   349: new 464	java/io/FileInputStream
    //   352: dup
    //   353: aload 24
    //   355: invokespecial 467	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   358: astore 5
    //   360: iload_2
    //   361: istore 26
    //   363: iload 26
    //   365: ifne +287 -> 652
    //   368: aload 19
    //   370: astore_1
    //   371: aload 5
    //   373: astore 6
    //   375: aload 20
    //   377: astore 4
    //   379: aload 5
    //   381: astore 7
    //   383: aload 5
    //   385: aload_3
    //   386: invokestatic 469	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   389: astore_0
    //   390: aload_0
    //   391: astore_1
    //   392: aload 5
    //   394: astore 6
    //   396: aload_0
    //   397: astore 4
    //   399: aload 5
    //   401: astore 7
    //   403: aload 5
    //   405: invokestatic 473	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   408: aload 15
    //   410: astore_3
    //   411: aload 9
    //   413: astore_1
    //   414: aload 14
    //   416: astore 4
    //   418: aload_0
    //   419: ifnull +503 -> 922
    //   422: aload_0
    //   423: astore_1
    //   424: aload 5
    //   426: astore 6
    //   428: aload_0
    //   429: astore 4
    //   431: aload 5
    //   433: astore 7
    //   435: new 475	java/io/InputStreamReader
    //   438: dup
    //   439: aload_0
    //   440: invokespecial 477	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   443: astore_3
    //   444: new 479	java/io/BufferedReader
    //   447: dup
    //   448: aload_3
    //   449: sipush 1024
    //   452: invokespecial 482	java/io/BufferedReader:<init>	(Ljava/io/Reader;I)V
    //   455: astore_1
    //   456: new 484	java/lang/StringBuffer
    //   459: dup
    //   460: invokespecial 485	java/lang/StringBuffer:<init>	()V
    //   463: astore 4
    //   465: aload_1
    //   466: invokevirtual 488	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   469: astore 6
    //   471: aload 6
    //   473: ifnull +409 -> 882
    //   476: aload 4
    //   478: aload 6
    //   480: invokevirtual 491	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   483: pop
    //   484: goto -19 -> 465
    //   487: astore 4
    //   489: aload_3
    //   490: astore 4
    //   492: aload_1
    //   493: astore_3
    //   494: aload 4
    //   496: astore_1
    //   497: aload_3
    //   498: ifnull +7 -> 505
    //   501: aload_3
    //   502: invokevirtual 494	java/io/BufferedReader:close	()V
    //   505: aload_1
    //   506: ifnull +7 -> 513
    //   509: aload_1
    //   510: invokevirtual 495	java/io/InputStreamReader:close	()V
    //   513: aload_0
    //   514: ifnull +7 -> 521
    //   517: aload_0
    //   518: invokevirtual 498	java/io/InputStream:close	()V
    //   521: aload 8
    //   523: astore_0
    //   524: aload 5
    //   526: ifnull +11 -> 537
    //   529: aload 5
    //   531: invokevirtual 499	java/io/FileInputStream:close	()V
    //   534: aload 8
    //   536: astore_0
    //   537: aload_0
    //   538: areturn
    //   539: ldc 8
    //   541: astore_0
    //   542: goto -493 -> 49
    //   545: ldc 8
    //   547: astore_0
    //   548: goto -452 -> 96
    //   551: aload_0
    //   552: astore 5
    //   554: iload_2
    //   555: istore 26
    //   557: aload 19
    //   559: astore_1
    //   560: aload 17
    //   562: astore 6
    //   564: aload 20
    //   566: astore 4
    //   568: aload 18
    //   570: astore 7
    //   572: aload 23
    //   574: invokevirtual 459	java/io/File:exists	()Z
    //   577: ifeq -214 -> 363
    //   580: aload_0
    //   581: astore 5
    //   583: iload_2
    //   584: istore 26
    //   586: aload 19
    //   588: astore_1
    //   589: aload 17
    //   591: astore 6
    //   593: aload 20
    //   595: astore 4
    //   597: aload 18
    //   599: astore 7
    //   601: aload 23
    //   603: invokevirtual 462	java/io/File:isFile	()Z
    //   606: ifeq -243 -> 363
    //   609: aload 19
    //   611: astore_1
    //   612: aload 17
    //   614: astore 6
    //   616: aload 20
    //   618: astore 4
    //   620: aload 18
    //   622: astore 7
    //   624: new 464	java/io/FileInputStream
    //   627: dup
    //   628: aload 23
    //   630: invokespecial 467	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   633: astore 5
    //   635: iload_2
    //   636: ifne +11 -> 647
    //   639: iconst_1
    //   640: istore_2
    //   641: iload_2
    //   642: istore 26
    //   644: goto -281 -> 363
    //   647: iconst_0
    //   648: istore_2
    //   649: goto -8 -> 641
    //   652: aload 5
    //   654: astore_0
    //   655: goto -247 -> 408
    //   658: aload 5
    //   660: astore_0
    //   661: aload 19
    //   663: astore_1
    //   664: aload 17
    //   666: astore 6
    //   668: aload 20
    //   670: astore 4
    //   672: aload 18
    //   674: astore 7
    //   676: invokestatic 505	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   679: invokevirtual 511	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   682: aload 21
    //   684: invokevirtual 517	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   687: astore 21
    //   689: iload_2
    //   690: ifne +166 -> 856
    //   693: aload 5
    //   695: astore_0
    //   696: aload 19
    //   698: astore_1
    //   699: aload 17
    //   701: astore 6
    //   703: aload 20
    //   705: astore 4
    //   707: aload 18
    //   709: astore 7
    //   711: aload 21
    //   713: aload_3
    //   714: invokestatic 469	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   717: astore 5
    //   719: aload 5
    //   721: astore_0
    //   722: aload 5
    //   724: astore_1
    //   725: aload 17
    //   727: astore 6
    //   729: aload 5
    //   731: astore 4
    //   733: aload 18
    //   735: astore 7
    //   737: aload 21
    //   739: invokestatic 473	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   742: aload 5
    //   744: astore_0
    //   745: aload 16
    //   747: astore 5
    //   749: goto -341 -> 408
    //   752: astore_1
    //   753: aload_0
    //   754: astore 5
    //   756: aload_0
    //   757: astore_1
    //   758: aload 17
    //   760: astore 6
    //   762: aload_0
    //   763: astore 4
    //   765: aload 18
    //   767: astore 7
    //   769: invokestatic 505	com/tencent/ttpic/util/VideoGlobalContext:getContext	()Landroid/content/Context;
    //   772: invokevirtual 511	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   775: aload 22
    //   777: invokevirtual 517	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   780: astore 19
    //   782: iload_2
    //   783: ifne +83 -> 866
    //   786: iconst_1
    //   787: istore 25
    //   789: iload 25
    //   791: ifne +81 -> 872
    //   794: aload_0
    //   795: astore 5
    //   797: aload_0
    //   798: astore_1
    //   799: aload 17
    //   801: astore 6
    //   803: aload_0
    //   804: astore 4
    //   806: aload 18
    //   808: astore 7
    //   810: aload 19
    //   812: aload_3
    //   813: invokestatic 469	com/tencent/ttpic/util/VideoTemplateParser:drinkACupOfCoffee	(Ljava/io/InputStream;Lcom/tencent/ttpic/util/DecryptListener;)Ljava/io/InputStream;
    //   816: astore_0
    //   817: aload_0
    //   818: astore 5
    //   820: aload_0
    //   821: astore_1
    //   822: aload 17
    //   824: astore 6
    //   826: aload_0
    //   827: astore 4
    //   829: aload 18
    //   831: astore 7
    //   833: aload 19
    //   835: invokestatic 473	com/tencent/util/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   838: aload 16
    //   840: astore 5
    //   842: goto -434 -> 408
    //   845: astore_0
    //   846: aload 5
    //   848: astore_0
    //   849: aload 16
    //   851: astore 5
    //   853: goto -445 -> 408
    //   856: aload 21
    //   858: astore_0
    //   859: aload 16
    //   861: astore 5
    //   863: goto -455 -> 408
    //   866: iconst_0
    //   867: istore 25
    //   869: goto -80 -> 789
    //   872: aload 19
    //   874: astore_0
    //   875: aload 16
    //   877: astore 5
    //   879: goto -471 -> 408
    //   882: aload 4
    //   884: invokevirtual 518	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   887: astore 4
    //   889: aload 4
    //   891: invokestatic 261	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   894: ifne +185 -> 1079
    //   897: new 520	org/json/JSONTokener
    //   900: dup
    //   901: aload 4
    //   903: invokespecial 521	org/json/JSONTokener:<init>	(Ljava/lang/String;)V
    //   906: invokevirtual 525	org/json/JSONTokener:nextValue	()Ljava/lang/Object;
    //   909: checkcast 64	org/json/JSONObject
    //   912: astore 6
    //   914: aload_3
    //   915: astore 4
    //   917: aload_1
    //   918: astore_3
    //   919: aload 6
    //   921: astore_1
    //   922: aload_3
    //   923: ifnull +7 -> 930
    //   926: aload_3
    //   927: invokevirtual 494	java/io/BufferedReader:close	()V
    //   930: aload 4
    //   932: ifnull +8 -> 940
    //   935: aload 4
    //   937: invokevirtual 495	java/io/InputStreamReader:close	()V
    //   940: aload_0
    //   941: ifnull +7 -> 948
    //   944: aload_0
    //   945: invokevirtual 498	java/io/InputStream:close	()V
    //   948: aload_1
    //   949: astore_0
    //   950: aload 5
    //   952: ifnull -415 -> 537
    //   955: aload 5
    //   957: invokevirtual 499	java/io/FileInputStream:close	()V
    //   960: aload_1
    //   961: areturn
    //   962: astore_0
    //   963: aload_1
    //   964: areturn
    //   965: astore_3
    //   966: aload 13
    //   968: astore_0
    //   969: aload 6
    //   971: astore 5
    //   973: aload_1
    //   974: astore 4
    //   976: aload 10
    //   978: astore_1
    //   979: aload_1
    //   980: ifnull +7 -> 987
    //   983: aload_1
    //   984: invokevirtual 494	java/io/BufferedReader:close	()V
    //   987: aload_0
    //   988: ifnull +7 -> 995
    //   991: aload_0
    //   992: invokevirtual 495	java/io/InputStreamReader:close	()V
    //   995: aload 4
    //   997: ifnull +8 -> 1005
    //   1000: aload 4
    //   1002: invokevirtual 498	java/io/InputStream:close	()V
    //   1005: aload 5
    //   1007: ifnull +8 -> 1015
    //   1010: aload 5
    //   1012: invokevirtual 499	java/io/FileInputStream:close	()V
    //   1015: aload_3
    //   1016: athrow
    //   1017: astore_0
    //   1018: goto -3 -> 1015
    //   1021: astore 6
    //   1023: aload 10
    //   1025: astore_1
    //   1026: aload_0
    //   1027: astore 4
    //   1029: aload_3
    //   1030: astore_0
    //   1031: aload 6
    //   1033: astore_3
    //   1034: goto -55 -> 979
    //   1037: astore 6
    //   1039: aload_0
    //   1040: astore 4
    //   1042: aload_3
    //   1043: astore_0
    //   1044: aload 6
    //   1046: astore_3
    //   1047: goto -68 -> 979
    //   1050: astore_0
    //   1051: aconst_null
    //   1052: areturn
    //   1053: astore_0
    //   1054: aload 11
    //   1056: astore_3
    //   1057: aload 4
    //   1059: astore_0
    //   1060: aload 7
    //   1062: astore 5
    //   1064: aload 12
    //   1066: astore_1
    //   1067: goto -570 -> 497
    //   1070: astore_1
    //   1071: aload_3
    //   1072: astore_1
    //   1073: aload 11
    //   1075: astore_3
    //   1076: goto -579 -> 497
    //   1079: aload_3
    //   1080: astore 4
    //   1082: aload_1
    //   1083: astore_3
    //   1084: aload 9
    //   1086: astore_1
    //   1087: goto -165 -> 922
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1090	0	paramString1	String
    //   0	1090	1	paramString2	String
    //   0	1090	2	paramBoolean	boolean
    //   0	1090	3	paramDecryptListener	DecryptListener
    //   10	467	4	localObject1	Object
    //   487	1	4	localException	Exception
    //   490	591	4	localObject2	Object
    //   40	1023	5	localObject3	Object
    //   149	821	6	localObject4	Object
    //   1021	11	6	localObject5	Object
    //   1037	8	6	localObject6	Object
    //   157	904	7	localObject7	Object
    //   4	531	8	localObject8	Object
    //   1	1084	9	localObject9	Object
    //   119	905	10	localObject10	Object
    //   122	952	11	localObject11	Object
    //   131	934	12	localObject12	Object
    //   128	839	13	localObject13	Object
    //   125	290	14	localObject14	Object
    //   116	293	15	localObject15	Object
    //   134	742	16	localObject16	Object
    //   137	686	17	localObject17	Object
    //   140	690	18	localObject18	Object
    //   107	766	19	localInputStream	InputStream
    //   110	594	20	localObject19	Object
    //   58	799	21	localObject20	Object
    //   104	672	22	str	String
    //   194	435	23	localFile1	java.io.File
    //   168	186	24	localFile2	java.io.File
    //   787	81	25	i	int
    //   361	282	26	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   456	465	487	java/lang/Exception
    //   465	471	487	java/lang/Exception
    //   476	484	487	java/lang/Exception
    //   882	914	487	java/lang/Exception
    //   676	689	752	java/io/IOException
    //   711	719	752	java/io/IOException
    //   737	742	752	java/io/IOException
    //   769	782	845	java/io/IOException
    //   810	817	845	java/io/IOException
    //   833	838	845	java/io/IOException
    //   926	930	962	java/io/IOException
    //   935	940	962	java/io/IOException
    //   944	948	962	java/io/IOException
    //   955	960	962	java/io/IOException
    //   159	170	965	finally
    //   185	196	965	finally
    //   211	219	965	finally
    //   234	242	965	finally
    //   257	265	965	finally
    //   280	288	965	finally
    //   303	311	965	finally
    //   326	334	965	finally
    //   349	360	965	finally
    //   383	390	965	finally
    //   403	408	965	finally
    //   435	444	965	finally
    //   572	580	965	finally
    //   601	609	965	finally
    //   624	635	965	finally
    //   676	689	965	finally
    //   711	719	965	finally
    //   737	742	965	finally
    //   769	782	965	finally
    //   810	817	965	finally
    //   833	838	965	finally
    //   983	987	1017	java/io/IOException
    //   991	995	1017	java/io/IOException
    //   1000	1005	1017	java/io/IOException
    //   1010	1015	1017	java/io/IOException
    //   444	456	1021	finally
    //   456	465	1037	finally
    //   465	471	1037	finally
    //   476	484	1037	finally
    //   882	914	1037	finally
    //   501	505	1050	java/io/IOException
    //   509	513	1050	java/io/IOException
    //   517	521	1050	java/io/IOException
    //   529	534	1050	java/io/IOException
    //   159	170	1053	java/lang/Exception
    //   185	196	1053	java/lang/Exception
    //   211	219	1053	java/lang/Exception
    //   234	242	1053	java/lang/Exception
    //   257	265	1053	java/lang/Exception
    //   280	288	1053	java/lang/Exception
    //   303	311	1053	java/lang/Exception
    //   326	334	1053	java/lang/Exception
    //   349	360	1053	java/lang/Exception
    //   383	390	1053	java/lang/Exception
    //   403	408	1053	java/lang/Exception
    //   435	444	1053	java/lang/Exception
    //   572	580	1053	java/lang/Exception
    //   601	609	1053	java/lang/Exception
    //   624	635	1053	java/lang/Exception
    //   676	689	1053	java/lang/Exception
    //   711	719	1053	java/lang/Exception
    //   737	742	1053	java/lang/Exception
    //   769	782	1053	java/lang/Exception
    //   810	817	1053	java/lang/Exception
    //   833	838	1053	java/lang/Exception
    //   444	456	1070	java/lang/Exception
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\util\VideoTemplateParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */