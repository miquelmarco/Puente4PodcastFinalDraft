setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                archives: [],
                filteredAr: [],
                checked: [],
                searchInput: '',
                isLoading: false,
            }
        },
        created() {
            axios.get(`/api/archives/getArchives`)
                .then(res => {
                    this.archives = res.data.sort((a, b) => b.id - a.id)
                    console.log(this.archives)
                }).catch(err => console.log(err))
        },
        methods: {
            
        },
        computed: {
            filtroEpCheckSearch() {
                this.filteredAr = this.archives.filter(archive => archive.name.toLowerCase().includes(this.searchInput.toLowerCase()))
            }
        }
    }).mount("#app")
}, 1000)