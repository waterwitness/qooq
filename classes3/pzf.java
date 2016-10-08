import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.app.IndividualRedPacketManager;
import com.tencent.mobileqq.app.IndividualRedPacketManager.FontBitmap;
import com.tencent.mobileqq.app.IndividualRedPacketManager.VIPHBStrategy;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.Char300Info;
import com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.RedPacketTemplateInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class pzf
  implements Runnable
{
  public pzf(IndividualRedPacketManager.VIPHBStrategy paramVIPHBStrategy, IndividualRedPacketManager paramIndividualRedPacketManager, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void run()
  {
    Object localObject8 = null;
    Object localObject7 = null;
    Object localObject4;
    Object localObject5;
    if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a) == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(IndividualRedPacketManager.b(), 2, "VIPHBStrategy.get not in local map. Id = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a + "content = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString + "mTemplateInfoMap.size=" + this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().a.size());
      }
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().getLong("RedPacketUpdateJson", 0L);
      synchronized (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.c)) {
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.c, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.c + "_tp")) {
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.c + "_tp", this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
        }
      }
      do
      {
        synchronized (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_JavaUtilMap)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_JavaUtilMap.containsKey(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a))
          {
            ArrayList localArrayList = new ArrayList();
            localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.c);
            this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_JavaUtilMap.put(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, localArrayList);
            if (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get())
            {
              if (QLog.isColorLevel()) {
                QLog.d(IndividualRedPacketManager.b(), 2, "VIPHBStrategy.get isJsonParseFinish = true");
              }
              return;
              localObject2 = finally;
              throw ((Throwable)localObject2);
            }
          }
          else
          {
            ((List)this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_JavaUtilMap.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a)).add(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.c);
          }
        }
      } while (l1 - l2 <= 1200000L);
      if (QLog.isColorLevel()) {
        QLog.d(IndividualRedPacketManager.b(), 2, "VIPHBStrategy.get startDownload Json id = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a + " content = " + this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString + " not exists!");
      }
      ??? = IndividualRedPacketManager.VIPHBStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$VIPHBStrategy).getApplication().getApplicationContext();
      localObject4 = new File(((Context)???).getFilesDir(), ClubContentJsonTask.k.jdField_b_of_type_JavaLangString);
      localObject5 = new Bundle();
      ((Bundle)localObject5).putInt("version", ClubContentJsonTask.a((Context)???, ClubContentJsonTask.k.e));
      ((Bundle)localObject5).putString("version_key", ClubContentJsonTask.k.e);
      ((Bundle)localObject5).putString("method", "redPacketUpdateNow");
      ((Bundle)localObject5).putString("ifromet", "redPacket");
      ((Bundle)localObject5).putBoolean("forceUpdate", true);
      ClubContentJsonTask.a(IndividualRedPacketManager.VIPHBStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$VIPHBStrategy), ClubContentJsonTask.k, null, (File)localObject4, (Bundle)localObject5);
      this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().edit().putLong("RedPacketUpdateJson", l1).commit();
      return;
    }
    IndividualRedPacketResDownloader.RedPacketTemplateInfo localRedPacketTemplateInfo = (IndividualRedPacketResDownloader.RedPacketTemplateInfo)this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().a.get(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a);
    if ((localRedPacketTemplateInfo.a == IndividualRedPacketResDownloader.RedPacketTemplateInfo.b) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString)) && (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a((QQAppInterface)IndividualRedPacketManager.VIPHBStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$VIPHBStrategy)).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString))) {}
    for (??? = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 12);; ??? = null)
    {
      localObject4 = ???;
      if (TextUtils.isEmpty((CharSequence)???)) {
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString))
        {
          localObject4 = ???;
          if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a("", this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 9) != null) {}
        }
        else
        {
          localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 6);
        }
      }
      label855:
      Object localObject6;
      if (TextUtils.isEmpty((CharSequence)localObject4)) {
        if (localRedPacketTemplateInfo.e != 1)
        {
          ??? = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 6);
          localObject5 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a((IndividualRedPacketManager.FontBitmap)???, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo, 6);
          localObject6 = ???;
          label873:
          if ((localRedPacketTemplateInfo.a != IndividualRedPacketResDownloader.RedPacketTemplateInfo.b) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString)) || (!this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a((QQAppInterface)IndividualRedPacketManager.VIPHBStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$VIPHBStrategy)).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString))) {
            break label1494;
          }
        }
      }
      label1060:
      label1453:
      label1469:
      label1494:
      for (??? = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 13);; ??? = null)
      {
        localObject4 = ???;
        if (TextUtils.isEmpty((CharSequence)???)) {
          if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString))
          {
            localObject4 = ???;
            if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a("", this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 10) != null) {}
          }
          else
          {
            localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 7);
          }
        }
        if (TextUtils.isEmpty((CharSequence)localObject4))
        {
          if (localRedPacketTemplateInfo.e != 1)
          {
            ??? = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 7);
            this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a((IndividualRedPacketManager.FontBitmap)???, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo, 7);
          }
        }
        else
        {
          localObject4 = localObject8;
          if (localRedPacketTemplateInfo.a == IndividualRedPacketResDownloader.RedPacketTemplateInfo.b)
          {
            ??? = localObject7;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString))
            {
              ??? = localObject7;
              if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a().jdField_b_of_type_ComTencentMobileqqVasIndividualRedPacketResDownloader$Char300Info.a((QQAppInterface)IndividualRedPacketManager.VIPHBStrategy.a(this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager$VIPHBStrategy)).contains(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString)) {
                ??? = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 15);
              }
            }
            localObject4 = ???;
            if (TextUtils.isEmpty((CharSequence)???)) {
              if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString))
              {
                localObject4 = ???;
                if (this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a("", this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 10) != null) {}
              }
              else
              {
                localObject4 = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 15);
              }
            }
          }
          if (TextUtils.isEmpty((CharSequence)localObject4))
          {
            if (localRedPacketTemplateInfo.e == 1) {
              break label1453;
            }
            ??? = this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 15);
          }
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a((IndividualRedPacketManager.FontBitmap)???, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo, 15);
          if ((localObject6 != null) && (((IndividualRedPacketManager.FontBitmap)localObject6).jdField_a_of_type_AndroidGraphicsBitmap != null) && (!((IndividualRedPacketManager.FontBitmap)localObject6).jdField_a_of_type_Boolean) && (!((IndividualRedPacketManager.FontBitmap)localObject6).c)) {
            this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a(((IndividualRedPacketManager.FontBitmap)localObject6).jdField_a_of_type_AndroidGraphicsBitmap, "", this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 5);
          }
          if ((localObject5 == null) || ((((IndividualRedPacketManager.FontBitmap)localObject6).jdField_a_of_type_AndroidGraphicsBitmap == null) && (!((IndividualRedPacketManager.FontBitmap)localObject6).c))) {
            break;
          }
          if (!((IndividualRedPacketManager.FontBitmap)localObject6).b) {
            break label1469;
          }
          this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a((Bitmap)localObject5, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 12);
          return;
          ??? = new IndividualRedPacketManager.FontBitmap();
          ((IndividualRedPacketManager.FontBitmap)???).c = true;
          break label855;
          this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_AndroidGraphicsBitmap = IndividualRedPacketManager.a((String)localObject4, null);
          CustomizeStrategyFactory.a().a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo);
          localObject5 = null;
          localObject6 = null;
          break label873;
          ??? = new IndividualRedPacketManager.FontBitmap();
          ((IndividualRedPacketManager.FontBitmap)???).c = true;
          break label1060;
          ??? = new IndividualRedPacketManager.FontBitmap();
          ((IndividualRedPacketManager.FontBitmap)???).c = true;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppIndividualRedPacketManager.a((Bitmap)localObject5, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.a, this.jdField_a_of_type_ComTencentMobileqqActivityAioCustomizeStrategyFactory$RedPacketInfo.jdField_b_of_type_JavaLangString, 6);
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\pzf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */