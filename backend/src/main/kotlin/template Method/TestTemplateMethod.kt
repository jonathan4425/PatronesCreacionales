package templatemethod

import java.io.File

fun main(){
    val logDir = "C:/Users/Isis/OneDrive/Documentos/templatemethod/logs"
    val processDir = "C:/Users/Isis/OneDrive/Documentos/templatemethod/process"
    val files = arrayOf("C:/Users/Isis/OneDrive/Documentos/templatemethod/abc.drug",
        "C:/Users/Isis/OneDrive/Documentos/templatemethod/123.gry")
    println("> Monitoring start")

    val fileDrug = File(files[0])

    DrugstoreFileProcess(fileDrug, logDir, processDir).execute()

    println("File processed  > " + fileDrug.name)

    val fileGry = File(files[1])
    GroceryFileProcess(fileGry, logDir, processDir).execute()
    println("File processed  > " + fileGry.name)

}