

package lifetek.vn.utils;

import org.zeroturnaround.zip.ZipUtil;

import java.io.File;

import static lifetek.vn.constants.FrameworkConstants.EXTENT_REPORT_FOLDER_PATH;
import static lifetek.vn.constants.FrameworkConstants.Zipped_ExtentReports_Folder_Name;

public class ZipUtils {

    /* Make Zip file of Extent Reports in Project Root folder */
    public static void zip() {

        ZipUtil.pack(new File(EXTENT_REPORT_FOLDER_PATH), new File(Zipped_ExtentReports_Folder_Name));

        Log.info("Zipped " + Zipped_ExtentReports_Folder_Name + " folder successfully !!");
    }

}
