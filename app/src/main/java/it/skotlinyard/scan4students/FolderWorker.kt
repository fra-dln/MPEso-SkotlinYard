package it.skotlinyard.scan4students

import java.io.File

/*
Piccola nota sui Path:
tutti i path richiesti come attributi sono fatti in modo che lo / iniziale deve essere sempre fatto mentre
quello finale no (es: /ciao/comestai/moltobenegrazie)
*/
class FolderWorker {
    private val startPath = "/storage/emulated/0/Android/media/it.skotlinyard.scan4students/CameraX App"

    /*fun createNewDirectory(nameDir: String): Boolean{
        val folder = File(startPath, nameDir)
        if (folder.exists()) {
            return false
        } else {
            return folder.mkdirs()
        }
    }*/

    //PathToParent vuole il path name dalla cartella interna (quindi dallo startPath) fino al padre
    /*fun createNewSubDirectory(pathToParent: String,nameDir: String): Boolean{
        val folder = File(startPath + pathToParent, nameDir)
        if (folder.exists()) {
            return false
        } else {
            return folder.mkdirs()
        }
    }*/
    
    //Dato il pathToParent restituisce la cartella padre (lo usiamo per cambiare l'outputDirectory del file principale)
    //che contiene la posizione di dove le foto scattate veranno salvate
    /*fun setOutputDirectory(pathToParent: String): File{
        val mediaDir = File(startPath + pathToParent)
        return if (mediaDir != null && mediaDir.exists())
            mediaDir else return File(startPath)
    }*/

    /*fun deleteFile(nameFileToDelete: String){
        val listaFile = File(startPath).listFiles()
        println("Tot files: ${listaFile.size}")
        listaFile.forEach { i -> if(i.name == nameFileToDelete) i.delete() }
    }*/

    /*fun moveFileToNewLocation(pathFileParentOriginal: String , pathFileParentNew: String , nameFile: String) {
        File("$startPath$pathFileParentOriginal/$nameFile").let { sourceFile ->
            sourceFile.copyTo(File("$startPath$pathFileParentNew/$nameFile"))
            sourceFile.delete()
        }
    }*/

    fun getListFileFromDirectory(pathToParent: String): Array<out File>? {
        return File(startPath+pathToParent).listFiles()
    }

}