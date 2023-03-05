package simple.software.learn.springsecuritydemo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URLConnection;

@RestController
public class FileDownloadController {
    private static final String EXTERNAL_FILE_PATH = "C:\\Users\\robso\\Downloads\\File\\";

    @RequestMapping("/file/{fileName:.+}")
    public void downloadFile(HttpServletRequest request,
                             HttpServletResponse response,
                             @PathVariable("fileName") String fileName) throws IOException {

        final var file = new File(EXTERNAL_FILE_PATH + fileName);
        if (file.exists()) {
            String mimeType = URLConnection.guessContentTypeFromName(file.getName());
            if (mimeType != null) {
                mimeType = "application/octet-stream";
            }

            response.setContentType(mimeType);

            response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() + "\""));


            response.setContentLength((int) file.length());

            InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

            FileCopyUtils.copy(inputStream, response.getOutputStream());
        }
    }

}
