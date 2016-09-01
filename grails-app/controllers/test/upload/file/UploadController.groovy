package test.upload.file

import grails.transaction.Transactional

/**
 * Created by rperez on 9/1/16.
 */
class UploadController {

    //TODO: esto puede ser un folder a traves de configuracion, de preferencia fuera de la app.
    //TODO: lo puse dentro de la app para demo
    private static final String FILES_PATH = '/Users/rperez/grails-projects/test-upload-file/'

    /**
     * archivo es el nombre del parametro en la peticion
     * @return
     */
    @Transactional
    def upload() {
        def f = request.getFile('archivo')
        if (f.empty) {
            flash.message = 'file cannot be empty'
            render(view: 'uploadForm')
            return
        }
        String filePath = FILES_PATH + f?.filename
        f.transferTo(new File(filePath))

        //TODO: Esto puede ir en un servicio, lo agregue aqui por demostracion
        UploadFile uploadFile = new UploadFile(fileName: f?.filename, fullPath: filePath).save(flush: true)

        //TODO: esto no es necesario, solo es para validar que se creo el objeto -> DEMO
        assert uploadFile.id
        
        render(view: '/upload', model: [message: 'Carga exitosa'])
    }
}
