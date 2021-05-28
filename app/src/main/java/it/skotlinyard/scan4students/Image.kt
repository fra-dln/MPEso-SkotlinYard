package it.skotlinyard.scan4students

class Image {
    var imagePath:String?=null
    var imageName:String?=null

    constructor(imagePath: String?, imageName: String?) {
        this.imagePath = imagePath
        this.imageName = imageName
    }
    constructor()
    {}
}