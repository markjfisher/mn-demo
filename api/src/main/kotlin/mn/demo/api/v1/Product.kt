package mn.demo.api.v1

interface Product {
    val id: String
    val name: String
}

class ProductFromInterface(pid: String, pname: String) : Product {
    override val id = pid
    override val name = pname
}

data class ProductDataClass(val id: String, val name: String)

open class ProductOpen(val id: String, val name: String)

class ProductWithDesc(pid: String, pname: String, val desc: String) : ProductOpen(pid, pname)
