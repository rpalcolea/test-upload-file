package test.upload.file


class UploadFile {
    String fileName
    String fullPath

    static constraints = {
        fileName blank: false
        fullPath blank: false
    }
}
