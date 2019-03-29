package core.io;

import org.apache.commons.io.FilenameUtils;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

public class FileManager {

	private static final String FILE_KEY_SEPARATOR = "_";
	private static final String TEMP_FILES_FOLDER_PATH = "temp";
	private static final long TAMANHO_MAX_ARQUIVO = 50000;
	private static FileManager instance;

	public static FileManager getInstance() {

		if(instance == null) {

			instance = new FileManager();

		}

		return instance;

	}

	private FileManager() {

		if(TEMP_FILES_FOLDER_PATH == null || TEMP_FILES_FOLDER_PATH.trim().equals("")) {

			throw new IllegalStateException("Erro ao inicializar o FileManager. A pasta temporária não foi especificada");

		}

		File tempFileFolder = new File(TEMP_FILES_FOLDER_PATH);

		if(!tempFileFolder.exists()) try {

			this.createFolderIfNotExists(tempFileFolder);

		} catch (Exception exception) {



		}

		if(!tempFileFolder.isDirectory()) {

			throw new IllegalStateException("Erro ao inicializar o FileManager. A pasta temporária não é um diretório: " + TEMP_FILES_FOLDER_PATH);

		}

		if(!tempFileFolder.canWrite()) {

			throw new IllegalStateException("Erro ao inicializar o FileManager. Sem permissão de escrita para a pasta temporária: " + TEMP_FILES_FOLDER_PATH);

		}

	}

	public File getTempFilesFolder() {

		return new File(TEMP_FILES_FOLDER_PATH);

	}

	public static boolean validaArquivo(File file){

		ArrayList<String> extensoes = new ArrayList<>();
		extensoes.add("png");
		extensoes.add("jpg");
		extensoes.add("jpeg");
		extensoes.add("pdf");

		if(file.length() < TAMANHO_MAX_ARQUIVO && extensoes.contains(FilenameUtils.getExtension(file.getPath()))){

			return true;

		}

		return false;

	}

	public String getExtension(String fileName){

		return FilenameUtils.getExtension(fileName);

	}

	public String generateFileKey(String fileName, String folderName) {

		return folderName + FILE_KEY_SEPARATOR + fileName;

	}

	public String generateFileName(String extension) {

		return UUID.randomUUID().toString() + ((extension != null) ? "." + extension : "");

	}

	public String removerExtension(String fileName) {

		return fileName.substring(0, fileName.lastIndexOf("."));

	}

	public String getFolderName() throws IOException {

		String folderName = UUID.randomUUID().toString();
		File folder = new File(TEMP_FILES_FOLDER_PATH + folderName);

		this.createFolderIfNotExists(folder);

		return folderName;

	}

	public String createFile(byte [] fileBytes, String extension) throws IOException {

		String fileName = generateFileName(extension);
		String folderName = getFolderName();
		File file = new File(TEMP_FILES_FOLDER_PATH + folderName, fileName);

		writeFile(file, fileBytes);

		return generateFileKey(fileName, folderName);

	}

	public String createFile(String pathFileGenerated, byte [] fileBytes, String extension) throws IOException {

		String fileName = generateFileName(extension);
		File file = new File(pathFileGenerated, fileName);
		writeFile(file, fileBytes);

		return removerExtension(fileName);

	}

	private void writeFile(File file, byte[] fileBytes) throws IOException {

		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
		stream.write(fileBytes);
		stream.close();

	}

	private void createFolderIfNotExists(File folder) throws IOException {

		if(!folder.exists() && !folder.mkdir() && !folder.getAbsoluteFile().mkdirs()) {

			throw new IOException("Não foi possível criar a pasta temporária.");

		}

	}

}
