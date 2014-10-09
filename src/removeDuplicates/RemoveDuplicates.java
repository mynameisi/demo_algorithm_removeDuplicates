package removeDuplicates;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RemoveDuplicates {
	//用 Logger 类库进行程序的 log 工作
		private final static Logger logger = LoggerFactory.getLogger(RemoveDuplicates.class);

		public static void main(String args[]) throws Exception {

			/*
			 * 从文件中读行的常用pattern
			 * 参考：http://stackoverflow.com/questions/5868369/how-to-read-a-large-text-file-line-by-line-using-java
			 */
			BufferedReader br = new BufferedReader(new FileReader(new File("test/TestStrings")));
			String line;
			while ((line = br.readLine()) != null) {
				logger.debug(line+"   ---->   "+StringUtil.removeDuplicates(line));
			}
			br.close();

		}

}
