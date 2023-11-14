setTimeout(() => {
    let { createApp } = Vue;
    createApp({
        data() {
            return {
                current: [],
                archives: [],
                filteredAr: [],
                checked: [],
                searchInput: '',
                isLoading: false,
            }
        },
        created() {
            this.getCurrent()
            this.getArchives()
        },
        methods: {
            getCurrent(){
                axios.get(`/api/getCurrent`)
                .then(res => {
                    this.current = res.data
                    console.log(this.current)
                }).catch(err => console.log(err))
            },
            getArchives(){
                axios.get(`/api/archives/getArchives`)
                .then(res => {
                    this.archives = res.data.sort((a, b) => b.id - a.id)
                }).catch(err => console.log(err))
            }
        },
        computed: {
            filtroEpCheckSearch() {
                this.filteredAr = this.archives.filter(archive => archive.name.toLowerCase().includes(this.searchInput.toLowerCase()))
            }
        }
    }).mount("#app")
}, 1000)