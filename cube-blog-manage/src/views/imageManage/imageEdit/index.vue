<template>
    <div>
        <el-card>
            <el-form label-width="80px">
                <el-form-item label="图片名称">
                    <el-input placeholder="图片名称"></el-input>
                </el-form-item>
                <el-form-item label="图片描述">
                    <el-input placeholder="图片描述" type="textarea" rows="4"></el-input>
                </el-form-item>
                <el-form-item label="图片">
                    <el-upload
                        action="/dev-api/admin/product/fileUpload"
                        list-type="picture-card"
                        :on-preview="handlePictureCardPreview"
                    >
                        <i class="el-icon-plus"></i>
                    </el-upload>
                    <el-dialog :visible.sync="dialogVisible">
                        <img width="100%" :src="dialogImageUrl" alt="">
                    </el-dialog>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary">保存</el-button>
                    <el-button @click="cancel">取消</el-button>
                </el-form-item>
            </el-form>
        </el-card>
    </div> 
</template>

<script>
export default {
    name:'',
    data() {
        return {
            dialogVisible: false,
            dialogImageUrl: "",

        };
    },
    methods: {
        handlePictureCardPreview(file) {
            this.dialogImageUrl="file.url"
            this.dialogVisible = true
        },
        cancel() {
            this.$emit("changeScene", {scene: 0})
        }
    }
};
</script>

<style scoped lang="">

</style>
