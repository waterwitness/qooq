import android.os.Environment;
import android.view.View;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class rhk
{
  private int jdField_a_of_type_Int;
  File jdField_a_of_type_JavaIoFile;
  StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public rhk(DragSortListView paramDragSortListView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_JavaIoFile = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
    if (!this.jdField_a_of_type_JavaIoFile.exists()) {}
    try
    {
      this.jdField_a_of_type_JavaIoFile.createNewFile();
      return;
    }
    catch (IOException paramDragSortListView) {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append("<DSLVStates>\n");
    this.b = 0;
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_a_of_type_JavaLangStringBuilder.append("<DSLVState>\n");
      int j = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildCount();
      int k = this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.s();
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <Positions>");
      int i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(k + i).append(",");
        i += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("</Positions>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <Tops>");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i).getTop()).append(",");
        i += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("</Tops>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <Bottoms>");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i).getBottom()).append(",");
        i += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("</Bottoms>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <FirstExpPos>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c).append("</FirstExpPos>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <FirstExpBlankHeight>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c) - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.c)).append("</FirstExpBlankHeight>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <SecondExpPos>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d).append("</SecondExpPos>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <SecondExpBlankHeight>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d) - this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.b(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.d)).append("</SecondExpBlankHeight>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <SrcPos>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.e).append("</SrcPos>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <SrcHeight>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.l + this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.x()).append("</SrcHeight>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <ViewHeight>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getHeight()).append("</ViewHeight>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <LastY>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.o).append("</LastY>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <FloatY>").append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.jdField_a_of_type_Int).append("</FloatY>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("    <ShuffleEdges>");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.a(k + i, this.jdField_a_of_type_ComTencentMobileqqEmosmViewDragSortListView.getChildAt(i).getTop())).append(",");
        i += 1;
      }
      this.jdField_a_of_type_JavaLangStringBuilder.append("</ShuffleEdges>\n");
      this.jdField_a_of_type_JavaLangStringBuilder.append("</DSLVState>\n");
      this.jdField_a_of_type_Int += 1;
    } while (this.jdField_a_of_type_Int <= 1000);
    c();
    this.jdField_a_of_type_Int = 0;
  }
  
  public void c()
  {
    boolean bool = false;
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    for (;;)
    {
      try
      {
        if (this.b == 0)
        {
          FileWriter localFileWriter = new FileWriter(this.jdField_a_of_type_JavaIoFile, bool);
          localFileWriter.write(this.jdField_a_of_type_JavaLangStringBuilder.toString());
          this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
          localFileWriter.flush();
          localFileWriter.close();
          this.b += 1;
          return;
        }
      }
      catch (IOException localIOException)
      {
        return;
      }
      bool = true;
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_JavaLangStringBuilder.append("</DSLVStates>\n");
      c();
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\rhk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */